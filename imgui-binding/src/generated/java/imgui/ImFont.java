package imgui;

import imgui.binding.ImGuiStructDestroyable;

/**
 * Font runtime data and rendering.
 * In Dear ImGui 1.92+, a font may be baked at multiple sizes. Size-specific data lives in {@link ImFontBaked}.
 */
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
    public float getCurrentRasterizerDensity() {
        return nGetCurrentRasterizerDensity();
    }

    private native float nGetCurrentRasterizerDensity(); /*
        return THIS->CurrentRasterizerDensity;
    */

    /**
     * Legacy size originally passed to AddFont().
     * In 1.92+, size-specific glyph data is stored in ImFontBaked.
     */
    public float getFontSize() {
        return nGetFontSize();
    }

    /**
     * Legacy size originally passed to AddFont().
     * In 1.92+, size-specific glyph data is stored in ImFontBaked.
     */
    public void setFontSize(final float value) {
        nSetFontSize(value);
    }

    private native float nGetFontSize(); /*
        return THIS->LegacySize;
    */

    private native void nSetFontSize(float value); /*
        THIS->LegacySize = value;
    */

    /**
     * Character used for ellipsis rendering.
     */
    public short getEllipsisChar() {
        return nGetEllipsisChar();
    }

    /**
     * Character used for ellipsis rendering.
     */
    public void setEllipsisChar(final short value) {
        nSetEllipsisChar(value);
    }

    private native short nGetEllipsisChar(); /*
        return THIS->EllipsisChar;
    */

    private native void nSetEllipsisChar(short value); /*
        THIS->EllipsisChar = value;
    */

    /**
     * Character used if a glyph isn't found.
     */
    public short getFallbackChar() {
        return nGetFallbackChar();
    }

    /**
     * Character used if a glyph isn't found.
     */
    public void setFallbackChar(final short value) {
        nSetFallbackChar(value);
    }

    private native short nGetFallbackChar(); /*
        return THIS->FallbackChar;
    */

    private native void nSetFallbackChar(short value); /*
        THIS->FallbackChar = value;
    */

    /**
     * Legacy base font scale, multiplied by the per-window font scale.
     */
    public float getScale() {
        return nGetScale();
    }

    /**
     * Legacy base font scale, multiplied by the per-window font scale.
     */
    public void setScale(final float value) {
        nSetScale(value);
    }

    private native float nGetScale(); /*
        return THIS->Scale;
    */

    private native void nSetScale(float value); /*
        THIS->Scale = value;
    */

    public boolean isGlyphInFont(final int c) {
        return nIsGlyphInFont(c);
    }

    private native boolean nIsGlyphInFont(int c); /*
        return THIS->IsGlyphInFont((ImWchar)c);
    */

    public boolean isLoaded() {
        return nIsLoaded();
    }

    private native boolean nIsLoaded(); /*
        return THIS->IsLoaded();
    */

    public String getDebugName() {
        return nGetDebugName();
    }

    private native String nGetDebugName(); /*
        return env->NewStringUTF(THIS->GetDebugName());
    */

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public ImVec2 calcTextSizeA(final float size, final float maxWidth, final float wrapWidth, final String textBegin) {
        final ImVec2 dst = new ImVec2();
        nCalcTextSizeA(dst, size, maxWidth, wrapWidth, textBegin);
        return dst;
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public float calcTextSizeAX(final float size, final float maxWidth, final float wrapWidth, final String textBegin) {
        return nCalcTextSizeAX(size, maxWidth, wrapWidth, textBegin);
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public float calcTextSizeAY(final float size, final float maxWidth, final float wrapWidth, final String textBegin) {
        return nCalcTextSizeAY(size, maxWidth, wrapWidth, textBegin);
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public void calcTextSizeA(final ImVec2 dst, final float size, final float maxWidth, final float wrapWidth, final String textBegin) {
        nCalcTextSizeA(dst, size, maxWidth, wrapWidth, textBegin);
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public ImVec2 calcTextSizeA(final float size, final float maxWidth, final float wrapWidth, final String textBegin, final String textEnd) {
        final ImVec2 dst = new ImVec2();
        nCalcTextSizeA(dst, size, maxWidth, wrapWidth, textBegin, textEnd);
        return dst;
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public float calcTextSizeAX(final float size, final float maxWidth, final float wrapWidth, final String textBegin, final String textEnd) {
        return nCalcTextSizeAX(size, maxWidth, wrapWidth, textBegin, textEnd);
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public float calcTextSizeAY(final float size, final float maxWidth, final float wrapWidth, final String textBegin, final String textEnd) {
        return nCalcTextSizeAY(size, maxWidth, wrapWidth, textBegin, textEnd);
    }

    /**
     * 'max_width' stops rendering after a certain width (could be turned into a 2d size). FLT_MAX to disable.
     * 'wrap_width' enables automatic word-wrapping across multiple lines to fit into given width. 0.0f to disable.
     */
    public void calcTextSizeA(final ImVec2 dst, final float size, final float maxWidth, final float wrapWidth, final String textBegin, final String textEnd) {
        nCalcTextSizeA(dst, size, maxWidth, wrapWidth, textBegin, textEnd);
    }

    private native void nCalcTextSizeA(ImVec2 dst, float size, float maxWidth, float wrapWidth, String textBegin); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        Jni::ImVec2Cpy(env, THIS->CalcTextSizeA(size, maxWidth, wrapWidth, textBegin), dst);
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
    */

    private native float nCalcTextSizeAX(float size, float maxWidth, float wrapWidth, String obj_textBegin); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto _result = THIS->CalcTextSizeA(size, maxWidth, wrapWidth, textBegin).x;
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        return _result;
    */

    private native float nCalcTextSizeAY(float size, float maxWidth, float wrapWidth, String obj_textBegin); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto _result = THIS->CalcTextSizeA(size, maxWidth, wrapWidth, textBegin).y;
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        return _result;
    */

    private native void nCalcTextSizeA(ImVec2 dst, float size, float maxWidth, float wrapWidth, String textBegin, String textEnd); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto textEnd = obj_textEnd == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textEnd, JNI_FALSE);
        Jni::ImVec2Cpy(env, THIS->CalcTextSizeA(size, maxWidth, wrapWidth, textBegin, textEnd), dst);
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        if (textEnd != NULL) env->ReleaseStringUTFChars(obj_textEnd, textEnd);
    */

    private native float nCalcTextSizeAX(float size, float maxWidth, float wrapWidth, String obj_textBegin, String obj_textEnd); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto textEnd = obj_textEnd == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textEnd, JNI_FALSE);
        auto _result = THIS->CalcTextSizeA(size, maxWidth, wrapWidth, textBegin, textEnd).x;
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        if (textEnd != NULL) env->ReleaseStringUTFChars(obj_textEnd, textEnd);
        return _result;
    */

    private native float nCalcTextSizeAY(float size, float maxWidth, float wrapWidth, String obj_textBegin, String obj_textEnd); /*MANUAL
        auto textBegin = obj_textBegin == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textBegin, JNI_FALSE);
        auto textEnd = obj_textEnd == NULL ? NULL : (char*)env->GetStringUTFChars(obj_textEnd, JNI_FALSE);
        auto _result = THIS->CalcTextSizeA(size, maxWidth, wrapWidth, textBegin, textEnd).y;
        if (textBegin != NULL) env->ReleaseStringUTFChars(obj_textBegin, textBegin);
        if (textEnd != NULL) env->ReleaseStringUTFChars(obj_textEnd, textEnd);
        return _result;
    */

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

    public void renderChar(final ImDrawList drawList, final float size, final ImVec2 pos, final int col, final int c) {
        nRenderChar(drawList.ptr, size, pos.x, pos.y, col, c);
    }

    public void renderChar(final ImDrawList drawList, final float size, final float posX, final float posY, final int col, final int c) {
        nRenderChar(drawList.ptr, size, posX, posY, col, c);
    }

    private native void nRenderChar(long drawList, float size, float posX, float posY, int col, int c); /*MANUAL
        ImVec2 pos = ImVec2(posX, posY);
        THIS->RenderChar(reinterpret_cast<ImDrawList*>(drawList), size, pos, col, (ImWchar)c);
    */

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
