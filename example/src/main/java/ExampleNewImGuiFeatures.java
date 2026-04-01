import imgui.ImGui;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiInputTextFlags;
import imgui.flag.ImGuiKey;
import imgui.flag.ImGuiWindowFlags;
import imgui.type.ImBoolean;
import imgui.type.ImString;

public final class ExampleNewImGuiFeatures {
    private static final String SAMPLE_TEXT = String.join("\n",
        "Dear ImGui 1.92 adds WordWrap for InputTextMultiline, so long lines can stay readable without horizontal scrolling. " +
            "This paragraph is intentionally long and uses regular prose instead of short labels, because wrap behavior is easier to verify on natural text.",
        "",
        "Resize this window narrower and keep the checkbox enabled: the line above should reflow into multiple visual rows inside the editor. " +
            "If you disable wrapping, the same content should stay on long logical lines instead.",
        "",
        "Shortcuts are shown outside of the editor so the sample text itself stays focused on wrapping. " +
            "You can still edit this buffer, toggle read-only mode, and reset the original content at any time."
    );

    private static final ImBoolean ENABLE_WORD_WRAP = new ImBoolean(true);
    private static final ImBoolean READ_ONLY = new ImBoolean(false);
    private static final ImString MULTILINE_TEXT = new ImString(SAMPLE_TEXT, 2048);

    static {
        MULTILINE_TEXT.inputData.isResizable = true;
        MULTILINE_TEXT.inputData.resizeFactor = 256;
    }

    private ExampleNewImGuiFeatures() {
    }

    private static void resetSampleText() {
        MULTILINE_TEXT.set(SAMPLE_TEXT, true, 256);
    }

    public static void show(final ImBoolean showWindow) {
        ImGui.setNextWindowSize(720, 420, ImGuiCond.Once);
        ImGui.setNextWindowPos(
            ImGui.getMainViewport().getPosX() + 420,
            ImGui.getMainViewport().getPosY() + 80,
            ImGuiCond.Once
        );

        if (ImGui.shortcut(ImGuiKey.ImGuiMod_Ctrl | ImGuiKey.W)) {
            ENABLE_WORD_WRAP.set(!ENABLE_WORD_WRAP.get());
        }

        if (ImGui.shortcut(ImGuiKey.ImGuiMod_Ctrl | ImGuiKey.R)) {
            resetSampleText();
        }

        if (ImGui.begin("New Dear ImGui Features", showWindow, ImGuiWindowFlags.NoCollapse)) {
            ImGui.textWrapped("This window demonstrates API added in the Dear ImGui 1.92 line.");
            ImGui.text("Runtime Dear ImGui version: " + ImGui.getVersion());
            ImGui.separator();

            ImGui.setNextItemShortcut(ImGuiKey.ImGuiMod_Ctrl | ImGuiKey.W);
            ImGui.checkbox("Enable WordWrap for InputTextMultiline", ENABLE_WORD_WRAP);

            ImGui.sameLine();
            ImGui.checkbox("Read-only", READ_ONLY);

            ImGui.setNextItemShortcut(ImGuiKey.ImGuiMod_Ctrl | ImGuiKey.R);
            if (ImGui.button("Reset sample text")) {
                resetSampleText();
            }

            ImGui.sameLine();
            ImGui.text("Buffer: " + MULTILINE_TEXT.getLength() + " chars");

            int inputFlags = ImGuiInputTextFlags.AllowTabInput;
            if (ENABLE_WORD_WRAP.get()) {
                inputFlags |= ImGuiInputTextFlags.WordWrap;
                inputFlags |= ImGuiInputTextFlags.NoHorizontalScroll;
            }
            if (READ_ONLY.get()) {
                inputFlags |= ImGuiInputTextFlags.ReadOnly;
            }

            final float inputWidth = Math.max(1.0f, ImGui.getContentRegionAvailX());
            ImGui.inputTextMultiline("##wordWrapMultiline", MULTILINE_TEXT, inputWidth, 280, inputFlags);

            ImGui.separator();
            ImGui.textWrapped(
                "Notes: Ctrl+W toggles wrapping, Ctrl+R resets the sample text. When wrapping is enabled this demo also disables horizontal scrolling to make the reflow explicit."
            );
        }
        ImGui.end();
    }
}
