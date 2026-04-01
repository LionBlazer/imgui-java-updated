# Repository Guidelines

## Agent-Specific Instructions
In this chat, respond in Russian. When you need to validate or build changes, use JetBrains MCP tools only, especially the IntelliJ build action and IDE run configurations. Do not describe terminal Gradle build commands as the normal contributor workflow here.

## Project Structure & Module Organization
This is a multi-module Gradle repository for the Java Dear ImGui binding. Core modules live at the root:

- `imgui-binding`: Java API, JNI bridge, native sources, and JUnit tests.
- `imgui-lwjgl3`: GLFW/OpenGL backend integration for LWJGL 3.
- `imgui-app`: higher-level application wrapper and shaded runtime jar.
- `imgui-binding-natives`: platform-specific native packaging.
- `example`: runnable demo applications and bundled fonts.
- `buildSrc`: custom Gradle tasks, API generation, and native build scripts.

Generated Java bindings are written under `imgui-binding/src/generated/java`; handwritten sources live in `src/main/java`. Treat generated code as derived output unless your change is specifically about the generator.

## Build, Test, and Development Commands
Use IDE-integrated actions through MCP IntelliJ:

- Build the project or changed files with the IntelliJ build tool.
- Run demos from the IDE run configurations for the `example` module.
- Run tests from IDE test actions or run configurations instead of shell commands.

If you work on native code, initialize submodules before changing vendor assets or headers in `include/`.

## Coding Style & Naming Conventions
Follow `.editorconfig`: LF line endings, spaces for indentation, 4-space indents for `*.java` and `*.groovy`, and a 160-character soft limit. Use standard Java naming: `UpperCamelCase` for classes, `lowerCamelCase` for methods/fields, and keep packages under `imgui.*`. Match existing JNI file naming such as `jni_implot.cpp` and keep module-specific logic in its owning module.

## Testing Guidelines
Tests currently live in `imgui-binding/src/test/java` and use JUnit Jupiter. Name new tests `*Test.java` and keep them close to the affected API surface, for example `imgui/ImVec2Test.java`. Prefer targeted IDE test runs for touched classes, then a broader MCP-backed project build before opening a PR.

## Commit & Pull Request Guidelines
Use the repository’s conventional format: `feat(api): add docking flag`, `fix: correct ImPlot signature`, `build(deps): bump ...`. Supported types are `feat`, `fix`, `chore`, `docs`, and `build`; common scopes are `api`, `generator`, and `build`. PRs should target `main`, summarize the change, link the relevant issue, note dependency or native-binary impact, and mark whether docs were updated. Include screenshots or a short demo note when changing `example` behavior or visible UI output.
