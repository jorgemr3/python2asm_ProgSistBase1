# Documentación del Compilador Python to x86_64

## Índice de Documentación

Esta carpeta contiene la documentación completa del proyecto **Compilador Python a x86_64**. Los documentos están organizados para proporcionar información desde conceptos básicos hasta detalles técnicos avanzados.

### 📋 **Documentos Disponibles**

| Documento | Descripción | Audiencia |
|-----------|-------------|-----------|
| **[architecture.md](architecture.md)** | Arquitectura general del sistema, componentes principales y patrones de diseño | Desarrolladores, Arquitectos |
| **[user-guide.md](user-guide.md)** | Manual de instalación, uso y sintaxis soportada | Usuarios finales, Estudiantes |
| **[grammar-specification.md](grammar-specification.md)** | Especificación completa de la gramática ANTLR, tokens y reglas de producción | Desarrolladores de compiladores |
| **[development.md](development.md)** | Guía para contribuir al proyecto, extender funcionalidad y convenciones de código | Contribuidores, Desarrolladores |
| **[examples.md](examples.md)** | Ejemplos de código, casos de uso y limitaciones actuales | Usuarios, Testers |

### 🎯 **Guía de Lectura Recomendada**

#### **Para Usuarios Nuevos:**
1. Comenzar con **[user-guide.md](user-guide.md)** para instalación y uso básico
2. Revisar **[examples.md](examples.md)** para ver casos de uso prácticos
3. Consultar **[architecture.md](architecture.md)** si desea entender el funcionamiento interno

#### **Para Desarrolladores:**
1. Leer **[architecture.md](architecture.md)** para comprender el diseño
2. Estudiar **[grammar-specification.md](grammar-specification.md)** para entender la gramática
3. Seguir **[development.md](development.md)** para contribuir al proyecto
4. Usar **[examples.md](examples.md)** como referencia para testing

#### **Para Estudiantes de Compiladores:**
1. Iniciar con **[grammar-specification.md](grammar-specification.md)** para comprender ANTLR
2. Continuar con **[architecture.md](architecture.md)** para el patrón AST/Visitor
3. Experimentar con **[examples.md](examples.md)** para casos prácticos
4. Explorar **[development.md](development.md)** para extensiones

### 📖 **Resumen del Proyecto**

El **Compilador Python to x86_64** es una implementación educativa que transforma un subconjunto del lenguaje Python en código ensamblador x86_64. El proyecto demuestra los conceptos fundamentales de construcción de compiladores utilizando tecnologías modernas.

#### **Características Principales:**
- ✅ **Sintaxis Python**: Soporte para indentación, variables, expresiones
- ✅ **Estructuras de Control**: Ciclos `for` y `while`
- ✅ **Tipos de Datos**: Enteros, strings y booleanos
- ✅ **Expresiones**: Aritméticas, lógicas y de comparación
- ✅ **Generación ASM**: Código x86_64 optimizado para Linux

#### **Stack Tecnológico:**
- **ANTLR 4.13.2**: Generación de parsers
- **Java 8+**: Lenguaje de implementación
- **x86_64 Assembly**: Target de compilación
- **Linux ABI**: Convenciones de llamadas del sistema

### 📁 **Estructura de Documentación**

```
documentation/
├── README.md                    # Este archivo - índice general
├── architecture.md              # Diseño y componentes del sistema  
├── user-guide.md               # Manual de usuario e instalación
├── grammar-specification.md     # Especificación completa de gramática ANTLR
├── development.md              # Guía de desarrollo y contribución
└── examples.md                 # Ejemplos de código y casos de uso
```

### 🚀 **Quick Start**

Si desea empezar rápidamente:

1. **Instalación Básica**: Ver [user-guide.md#instalación](user-guide.md#guía-de-instalación)
2. **Primer Ejemplo**: Consultar [examples.md#básicos](examples.md#casos-de-uso-básicos)
3. **Compilar Código**: Seguir [user-guide.md#uso](user-guide.md#uso-del-compilador)

### 🔧 **Para Contribuidores**

Si desea contribuir al proyecto:

1. **Setup de Desarrollo**: [development.md#setup](development.md#configuración-del-entorno-de-desarrollo)
2. **Agregar Features**: [development.md#extensiones](development.md#flujo-de-desarrollo)
3. **Testing**: [development.md#testing](development.md#testing)
4. **Code Style**: [development.md#convenciones](development.md#convenciones-de-código)

### 📚 **Referencias Adicionales**

#### **Documentación Externa:**
- [ANTLR 4 Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
- [x86_64 Assembly Reference](https://www.felixcloutier.com/x86/)
- [System V ABI](https://uclibc.org/docs/psABI-x86_64.pdf)

#### **Recursos Académicos:**
- **Compiladores**: "Engineering a Compiler" por Cooper & Torczon
- **ANTLR**: "The Definitive ANTLR 4 Reference" por Terence Parr
- **Assembly**: "Programming from the Ground Up" por Jonathan Bartlett

### 🐛 **Reporte de Issues**

Para reportar problemas o sugerir mejoras:

1. **Bugs**: Seguir template en [development.md#bug-reports](development.md#bug-reports)
2. **Feature Requests**: Crear issue con etiqueta "enhancement"
3. **Preguntas**: Usar etiqueta "question" en issues

### 📄 **Licencia y Uso**

Este proyecto está desarrollado con fines educativos. Consulte el archivo `LICENSE` en el directorio raíz para información sobre términos de uso.

### 📊 **Estado del Proyecto**

| Componente | Estado | Notas |
|------------|---------|-------|
| Lexer/Parser | ✅ Completo | ANTLR 4.13.2 |
| AST | ✅ Completo | Patrón Visitor |
| CodeGen | ✅ Completo | x86_64 básico |
| Testing | ✅ Funcional | Casos de prueba |
| Documentation | ✅ Completo | Esta documentación |
| **Features Pendientes** |
| If/Else | ⏳ Pendiente | Condicionales |
| Functions | ⏳ Pendiente | Funciones de usuario |
| Arrays | ⏳ Pendiente | Estructuras de datos |

### 🔄 **Última Actualización**

**Versión**: 1.0
**Fecha**: Diciembre 2024
**Autor**: Jorge Melo
**Estado**: Funcional y documentado

Para información sobre versiones y changelog, ver el historial de commits en el repositorio principal.

---

**💡 Tip**: Mantenga esta documentación actualizada conforme evolucione el proyecto. Cada nueva característica debe incluir ejemplos en `examples.md` y consideraciones de desarrollo en `development.md`.