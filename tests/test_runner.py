import os
import subprocess
import sys

ERROR_PREFIXES = ("[ERROR]", "[LEX]", "[SYN]", "[INDENT]", "[SEMANTIC]")


def _list_py_files(folder_path):
    if not os.path.isdir(folder_path):
        return []
    files = []
    for name in os.listdir(folder_path):
        if not name.endswith(".py"):
            continue
        full_path = os.path.join(folder_path, name)
        if os.path.isfile(full_path):
            files.append(full_path)
    return sorted(files)


def _collect_errors(stderr_text, return_code):
    lines = stderr_text.splitlines()
    err_lines = [line for line in lines if line.strip().startswith(ERROR_PREFIXES)]
    if return_code != 0 and not err_lines:
        err_lines.append("[ERROR] Proceso fallo con codigo " + str(return_code))
    return err_lines


def _run_test(java_cmd, cwd, test_path):
    result = subprocess.run(
        java_cmd + [test_path],
        cwd=cwd,
        capture_output=True,
        text=True,
    )
    err_lines = _collect_errors(result.stderr, result.returncode)
    return result, err_lines


def main():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    root = os.path.abspath(os.path.join(script_dir, os.pardir))

    build_dir = os.path.join(root, "build")
    antlr_jar = os.path.join(root, "lib", "antlr-4.13.2-complete.jar")
    if not os.path.isdir(build_dir) or not os.path.isfile(antlr_jar):
        print("[ERROR] Falta build/ o lib/antlr-4.13.2-complete.jar")
        print("Compila el proyecto antes de ejecutar tests.")
        return 1

    classpath = os.pathsep.join([build_dir, antlr_jar])
    java_cmd = ["java", "-cp", classpath, "parser.Main"]

    valid_dir = os.path.join(root, "tests", "valid")
    invalid_dir = os.path.join(root, "tests", "invalid")

    valid_tests = _list_py_files(valid_dir)
    invalid_tests = _list_py_files(invalid_dir)

    if not valid_tests and not invalid_tests:
        print("[ERROR] No se encontraron tests en tests/valid o tests/invalid")
        return 1

    total = 0
    true_positive = 0
    true_negative = 0
    false_positive = 0
    false_negative = 0

    print("=== Tests valid ===")
    for test_path in valid_tests:
        total += 1
        result, err_lines = _run_test(java_cmd, root, test_path)
        if not err_lines:
            print("[OK] " + os.path.relpath(test_path, root))
            true_negative += 1
        else:
            print("[FAIL] " + os.path.relpath(test_path, root))
            for line in err_lines[:3]:
                print("  " + line)
            false_positive += 1

    print("\n=== Tests invalid ===")
    for test_path in invalid_tests:
        total += 1
        result, err_lines = _run_test(java_cmd, root, test_path)
        if err_lines:
            print("[OK] " + os.path.relpath(test_path, root))
            print("  " + err_lines[0])
            true_positive += 1
        else:
            print("[FAIL] " + os.path.relpath(test_path, root))
            print("  [ERROR] Se esperaba error y la compilacion termino sin errores")
            false_negative += 1

    passed = true_positive + true_negative
    failed = false_positive + false_negative

    print("\n=== Resumen ===")
    print("Total: " + str(total))
    print("OK: " + str(passed))
    print("FAIL: " + str(failed))
    print("TP (invalid con error): " + str(true_positive))
    print("TN (valid sin error): " + str(true_negative))
    print("FP (valid con error): " + str(false_positive))
    print("FN (invalid sin error): " + str(false_negative))

    return 0 if failed == 0 else 1


if __name__ == "__main__":
    sys.exit(main())
