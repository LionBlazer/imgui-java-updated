# Native Build In WSL

Короткая памятка по сборке Windows native-биндинга Dear ImGui из этого репозитория через `WSL + mingw-w64`.

Это именно тот сценарий, который был использован в этом проекте при обновлении на Dear ImGui `1.92.5`.

## Что нужно в WSL

Проверенный вариант: `Ubuntu` в `WSL2`.

Нужные пакеты:

```bash
sudo apt update
sudo apt install -y mingw-w64 ant openjdk-17-jdk
```

После этого в `PATH` должны быть:

- `x86_64-w64-mingw32-g++`
- `x86_64-w64-mingw32-strip`
- `ant`

## Почему не `./gradlew`

В этом репозитории `gradlew` может мешать из-за Windows line endings при запуске из WSL.
Поэтому надёжный путь здесь такой: запускать Gradle wrapper напрямую через jar.

## Подготовка окружения

Перед сборкой выставить Java 17:

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
```

Проверка:

```bash
java -version
x86_64-w64-mingw32-g++ --version
x86_64-w64-mingw32-strip --version
ant -version
```

## Команда сборки

Из корня проекта:

```bash
java -classpath gradle/wrapper/gradle-wrapper.jar \
  org.gradle.wrapper.GradleWrapperMain \
  :imgui-binding:generateApi \
  imgui-binding:generateLibs \
  -Denvs=windows \
  -Dlocal
```

Что делает эта команда:

- регенерирует Java/JNI API
- собирает Windows native DLL через `mingw-w64`
- пакует native jar

## Где лежит результат

Основной артефакт:

- `imgui-binding/build/libsNative/windows64/imgui-java64.dll`

Упакованный jar:

- `imgui-binding/build/libsNative/imgui-java-natives.jar`

## Как запускать example

После сборки запускать пример через IDE run configuration:

- `ImguiJavaUpdated [:example:run]`

В этом проекте `example/build.gradle` уже настроен так, что при наличии локально собранной native-библиотеки он по умолчанию берёт:

- `imgui-binding/build/libsNative/windows64`

То есть отдельный `-Dimgui.library.path=...` руками обычно уже не нужен.

## Полезные замечания

- Если приложение уже было открыто, после пересборки DLL его надо полностью перезапустить.
- Если поведение вызывает сомнения, в demo-окне можно смотреть runtime-версию через `ImGui.getVersion()`.
- Если сборка валится на vendor-коде (`implot`, `imnodes`, и т.д.), это обычно не проблема toolchain, а несовместимость vendored extension с текущей версией Dear ImGui.

## Минимальный чек-лист

1. Открыть WSL в корне репозитория.
2. Выставить `JAVA_HOME` на Java 17.
3. Убедиться, что `x86_64-w64-mingw32-g++` и `x86_64-w64-mingw32-strip` доступны.
4. Запустить `generateApi + generateLibs`.
5. Проверить наличие `imgui-binding/build/libsNative/windows64/imgui-java64.dll`.
6. Перезапустить `example` из IDE.
