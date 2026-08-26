#!/bin/bash

# Set base directory and navigate to project root
echo "Setting base directory and navigating to project root..."
BASEDIR=$(dirname "$0")
cd "$BASEDIR"/../.. || exit 1
echo "Navigated to $(pwd)"

echo '> Publishing Modules...'
NATIVE_PUBLISH_DIR="${NATIVE_PUBLISH_DIR:-out/artifacts/native-libraries}"
CENTRAL_NAMESPACE="${CENTRAL_NAMESPACE:-io.github.lionblazer}"
CENTRAL_PUBLISHING_TYPE="${CENTRAL_PUBLISHING_TYPE:-user_managed}"

publish_module() {
    local module=$1
    echo ">> Publishing Module [$module]"
    ./gradlew $module:publishImguiPublicationToMavenCentralRepository -PnativePublishDir="$NATIVE_PUBLISH_DIR"
    if [ $? -ne 0 ]; then
        echo "Failed to publish $module module"
        exit 1
    fi
    echo ">> Module [$module] published successfully"
}

# Publish each module
publish_module "imgui-app"
publish_module "imgui-lwjgl3"
publish_module "imgui-binding"

echo '> Publishing Natives...'

publish_natives() {
    local platform=$1
    echo ">> Publishing Natives: [$platform]"
    ./gradlew imgui-binding-natives:publishImguiPublicationToMavenCentralRepository -PdeployType=$platform -PnativePublishDir="$NATIVE_PUBLISH_DIR"
    if [ $? -ne 0 ]; then
        echo "Failed to publish natives for $platform"
        exit 1
    fi
    echo ">> Natives for $platform published successfully"
}

# Publish natives for each platform
publish_natives "windows"
publish_natives "linux"
publish_natives "macos"

echo "> Uploading staging repository to Central Portal..."
CENTRAL_AUTH_TOKEN=$(printf '%s:%s' "$NEXUS_UPD_ID" "$NEXUS_UPD_PASS" | base64 | tr -d '\n')
curl --fail-with-body -D - -X POST \
    -H "Authorization: Bearer ${CENTRAL_AUTH_TOKEN}" \
    "https://ossrh-staging-api.central.sonatype.com/manual/upload/defaultRepository/${CENTRAL_NAMESPACE}?publishing_type=${CENTRAL_PUBLISHING_TYPE}"

echo "All modules and natives published successfully."
