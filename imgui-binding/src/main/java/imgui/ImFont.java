package imgui;

import imgui.binding.ImGuiStructDestroyable;
import imgui.binding.annotation.ArgValue;
import imgui.binding.annotation.BindingField;
import imgui.binding.annotation.BindingMethod;
import imgui.binding.annotation.BindingSource;
import imgui.binding.annotation.OptArg;

/**
 * Font runtime data and rendering.
 * In Dear ImGui 1.92+, a font may be baked at multiple sizes. Size-specific data lives in {@link ImFontBaked}.
 */
@BindingSource
public final class ImFont extends ImGuiStructDestroyable {
    public ImFont() {
        super();
    }

    public ImFont(final long ptr) {
        super(ptr);
    }

    @Override
    protected long create() {
        return nCreate();
    }

    /*JNI
        #include "_common.h"
        #define THIS ((ImFont*)STRUCT_PTR)
     */

    private native long nCreate(); /*
        return (uintptr_t)(new ImFont());
    */

    /**
     * Current rasterizer density. This is a varying state of the font.
     */
    @BindingField(accessors = BindingField.Accessor.GETTER)
    public float CurrentRasterizerDensity;

    /**
     * Legacy size originally passed to AddFont().
     * In 1.92+, size-specific glyph data is stored in ImFontBaked.
     */
    @BindingField(callName = "LegacySize")
    public float FontSize;

    /**
     * Character used for ellipsis rendering.
     */
    @BindingField
    public short EllipsisChar;

    /**
     * Character used if a glyph isn't found.
     */
    @BindingField
    public short FallbackChar;

    /**
     * Legacy base font scale, multiplied by the per-window font scale.
     */
    @BindingField
    public float Scale;

    @BindingMethod
    public native boolean IsGlyphInFont(@ArgValue(callPrefix = "(ImWchar)") int c);

    @BindingMethod
    public native boolean IsLoaded();

    @BindingMethod
    public native String GetDebugName();

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    @BindingMethod
    public native ImVec2 CalcTextSizeA(float size, float maxWidth, float wrapWidth, String textBegin, @OptArg String textEnd);

    public ImFontBaked getFontBaked(final float fontSize) {
        return new ImFontBaked(nGetFontBaked(fontSize, -1.0f));
    }

    public ImFontBaked getFontBaked(final float fontSize, final float density) {
        return new ImFontBaked(nGetFontBaked(fontSize, density));
    }

    private native long nGetFontBaked(float fontSize, float density); /*
        return (uintptr_t)THIS->GetFontBaked(fontSize, density);
    */

    /**
     * Returns the first position where a wrapped line should stop for the given baked size.
     */
    public String calcWordWrapPosition(final float size, final String text, final String textEnd, final float wrapWidth) {
        return nCalcWordWrapPosition(size, text, textEnd, wrapWidth);
    }

    private native String nCalcWordWrapPosition(float size, String objText, String objTextEnd, float wrapWidth); /*MANUAL
        auto text = objText == NULL ? NULL : (char*)env->GetStringUTFChars(objText, JNI_FALSE);
        auto textEnd = objTextEnd == NULL ? NULL : (char*)env->GetStringUTFChars(objTextEnd, JNI_FALSE);
        auto result = env->NewStringUTF(THIS->CalcWordWrapPosition(size, text, textEnd, wrapWidth));
        if (text != NULL) env->ReleaseStringUTFChars(objText, text);
        if (textEnd != NULL) env->ReleaseStringUTFChars(objTextEnd, textEnd);
        return result;
    */

    /**
     * Legacy wrapper preserved for source compatibility.
     * It scales the current legacy size and forwards to CalcWordWrapPosition().
     */
    public String calcWordWrapPositionA(final float scale, final String text, final String textEnd, final float wrapWidth) {
        return nCalcWordWrapPositionA(scale, text, textEnd, wrapWidth);
    }

    private native String nCalcWordWrapPositionA(float scale, String objText, String objTextEnd, float wrapWidth); /*MANUAL
        auto text = objText == NULL ? NULL : (char*)env->GetStringUTFChars(objText, JNI_FALSE);
        auto textEnd = objTextEnd == NULL ? NULL : (char*)env->GetStringUTFChars(objTextEnd, JNI_FALSE);
        auto result = env->NewStringUTF(THIS->CalcWordWrapPosition(THIS->LegacySize * scale, text, textEnd, wrapWidth));
        if (text != NULL) env->ReleaseStringUTFChars(objText, text);
        if (textEnd != NULL) env->ReleaseStringUTFChars(objTextEnd, textEnd);
        return result;
    */

    @BindingMethod
    public native void RenderChar(ImDrawList drawList, float size, ImVec2 pos, int col, @ArgValue(callPrefix = "(ImWchar)") int c);

    public void renderText(final ImDrawList drawList, final float size, final ImVec2 pos, final int col, final ImVec4 clipRect, final String textBegin, final String textEnd) {
        nRenderText(drawList.ptr, size, pos.x, pos.y, col, clipRect.x, clipRect.y, clipRect.z, clipRect.w, textBegin, textEnd);
    }

    public void renderText(final ImDrawList drawList, final float size, final float posX, final float posY, final int col, final float clipRectX, final float clipRectY, final float clipRectZ, final float clipRectW, final String textBegin, final String textEnd) {
        nRenderText(drawList.ptr, size, posX, posY, col, clipRectX, clipRectY, clipRectZ, clipRectW, textBegin, textEnd);
    }

    public void renderText(final ImDrawList drawList, final float size, final ImVec2 pos, final int col, final ImVec4 clipRect, final String textBegin, final String textEnd, final float wrapWidth) {
        nRenderText(drawList.ptr, size, pos.x, pos.y, col, clipRect.x, clipRect.y, clipRect.z, clipRect.w, textBegin, textEnd, wrapWidth);
    }

    public void renderText(final ImDrawList drawList, final float size, final float posX, final float posY, final int col, final float clipRectX, final float clipRectY, final float clipRectZ, final float clipRectW, final String textBegin, final String textEnd, final float wrapWidth) {
        nRenderText(drawList.ptr, size, posX, posY, col, clipRectX, clipRectY, clipRectZ, clipRectW, textBegin, textEnd, wrapWidth);
    }

    public void renderText(final ImDrawList drawList, final float size, final ImVec2 pos, final int col, final ImVec4 clipRect, final String textBegin, final String textEnd, final float wrapWidth, final int flags) {
        nRenderText(drawList.ptr, size, pos.x, pos.y, col, clipRect.x, clipRect.y, clipRect.z, clipRect.w, textBegin, textEnd, wrapWidth, flags);
    }

    public void renderText(final ImDrawList drawList, final float size, final float posX, final float posY, final int col, final float clipRectX, final float clipRectY, final float clipRectZ, final float clipRectW, final String textBegin, final String textEnd, final float wrapWidth, final int flags) {
        nRenderText(drawList.ptr, size, posX, posY, col, clipRectX, clipRectY, clipRectZ, clipRectW, textBegin, textEnd, wrapWidth, flags);
    }

    /**
     * Compatibility overload preserved for older code. cpuFineClip no longer maps to Dear ImGui 1.92 RenderText flags and is ignored.
     */
    public void renderText(final ImDrawList drawList, final float size, final ImVec2 pos, final int col, final ImVec4 clipRect, final String textBegin, final String textEnd, final float wrapWidth, final boolean cpuFineClip) {
        nRenderText(drawList.ptr, size, pos.x, pos.y, col, clipRect.x, clipRect.y, clipRect.z, clipRect.w, textBegin, textEnd, wrapWidth, 0);
    }

    /**
     * Compatibility overload preserved for older code. cpuFineClip no longer maps to Dear ImGui 1.92 RenderText flags and is ignored.
     */
    public void renderText(final ImDrawList drawList, final float size, final float posX, final float posY, final int col, final float clipRectX, final float clipRectY, final float clipRectZ, final float clipRectW, final String textBegin, final String textEnd, final float wrapWidth, final boolean cpuFineClip) {
        nRenderText(drawList.ptr, size, posX, posY, col, clipRectX, clipRectY, clipRectZ, clipRectW, textBegin, textEnd, wrapWidth, 0);
    }

    /**
     * Compatibility overload preserved for older code. cpuFineClip no longer maps to Dear ImGui 1.92 RenderText flags and is ignored.
     */
    public void renderText(final ImDrawList drawList, final float size, final ImVec2 pos, final int col, final ImVec4 clipRect, final String textBegin, final String textEnd, final boolean cpuFineClip) {
        nRenderText(drawList.ptr, size, pos.x, pos.y, col, clipRect.x, clipRect.y, clipRect.z, clipRect.w, textBegin, textEnd, 0.0f, 0);
    }

    /**
     * Compatibility overload preserved for older code. cpuFineClip no longer maps to Dear ImGui 1.92 RenderText flags and is ignored.
     */
    public void renderText(final ImDrawList drawList, final float size, final float posX, final float posY, final int col, final float clipRectX, final float clipRectY, final float clipRectZ, final float clipRectW, final String textBegin, final String textEnd, final boolean cpuFineClip) {
        nRenderText(drawList.ptr, size, posX, posY, col, clipRectX, clipRectY, clipRectZ, clipRectW, textBegin, textEnd, 0.0f, 0);
    }

    private native void nRenderText(long drawList, float size, float posX, float posY, int col, float clipRectX, float clipRectY, float clipRectZ, float clipRectW, String textBegin, String textEnd); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto textEnd = obj_textEnd == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textEnd, JNI_FALSE);
        ImVec2 pos = ImVec2(posX, posY);
        ImVec4 clipRect = ImVec4(clipRectX, clipRectY, clipRectZ, clipRectW);
        THIS->RenderText(reinterpret_cast<ImDrawList*>(drawList), size, pos, col, clipRect, textBegin, textEnd);
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        if (textEnd != NULL) env->ReleaseStringUTFChars(obj_textEnd, textEnd);
    */

    private native void nRenderText(long drawList, float size, float posX, float posY, int col, float clipRectX, float clipRectY, float clipRectZ, float clipRectW, String textBegin, String textEnd, float wrapWidth); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto textEnd = obj_textEnd == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textEnd, JNI_FALSE);
        ImVec2 pos = ImVec2(posX, posY);
        ImVec4 clipRect = ImVec4(clipRectX, clipRectY, clipRectZ, clipRectW);
        THIS->RenderText(reinterpret_cast<ImDrawList*>(drawList), size, pos, col, clipRect, textBegin, textEnd, wrapWidth);
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        if (textEnd != NULL) env->ReleaseStringUTFChars(obj_textEnd, textEnd);
    */

    private native void nRenderText(long drawList, float size, float posX, float posY, int col, float clipRectX, float clipRectY, float clipRectZ, float clipRectW, String textBegin, String textEnd, float wrapWidth, int flags); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto textEnd = obj_textEnd == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textEnd, JNI_FALSE);
        ImVec2 pos = ImVec2(posX, posY);
        ImVec4 clipRect = ImVec4(clipRectX, clipRectY, clipRectZ, clipRectW);
        THIS->RenderText(reinterpret_cast<ImDrawList*>(drawList), size, pos, col, clipRect, textBegin, textEnd, wrapWidth, (ImDrawTextFlags)flags);
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        if (textEnd != NULL) env->ReleaseStringUTFChars(obj_textEnd, textEnd);
    */

    /*JNI
        #undef THIS
     */
}
