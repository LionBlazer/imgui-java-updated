package imgui;

import imgui.binding.ImGuiStructDestroyable;

/**
 * Font runtime data for a given size.
 * Pointers to ImFontBaked are only valid for the current frame.
 */
public final class ImFontBaked extends ImGuiStructDestroyable {
    public ImFontBaked() {
        super();
    }

    public ImFontBaked(final long ptr) {
        super(ptr);
    }

    @Override
    protected long create() {
        return nCreate();
    }

    /*JNI
        #include "_common.h"
        #define THIS ((ImFontBaked*)STRUCT_PTR)
     */

    private native long nCreate(); /*
        return (uintptr_t)(new ImFontBaked());
    */

    // TODO IndexAdvanceX, IndexLookup, Glyphs

    /**
     * AdvanceX of the fallback glyph.
     */
    public float getFallbackAdvanceX() {
        return nGetFallbackAdvanceX();
    }

    /**
     * AdvanceX of the fallback glyph.
     */
    public void setFallbackAdvanceX(final float value) {
        nSetFallbackAdvanceX(value);
    }

    private native float nGetFallbackAdvanceX(); /*
        return THIS->FallbackAdvanceX;
    */

    private native void nSetFallbackAdvanceX(float value); /*
        THIS->FallbackAdvanceX = value;
    */

    /**
     * Height of characters/line for this baked size.
     */
    public float getFontSize() {
        return nGetFontSize();
    }

    /**
     * Height of characters/line for this baked size.
     */
    public void setFontSize(final float value) {
        nSetFontSize(value);
    }

    private native float nGetFontSize(); /*
        return THIS->Size;
    */

    private native void nSetFontSize(float value); /*
        THIS->Size = value;
    */

    /**
     * Rasterizer density this font was baked at.
     */
    public float getRasterizerDensity() {
        return nGetRasterizerDensity();
    }

    /**
     * Rasterizer density this font was baked at.
     */
    public void setRasterizerDensity(final float value) {
        nSetRasterizerDensity(value);
    }

    private native float nGetRasterizerDensity(); /*
        return THIS->RasterizerDensity;
    */

    private native void nSetRasterizerDensity(float value); /*
        THIS->RasterizerDensity = value;
    */

    /**
     * Index of FontFallbackChar in Glyphs.
     */
    public int getFallbackGlyphIndex() {
        return nGetFallbackGlyphIndex();
    }

    /**
     * Index of FontFallbackChar in Glyphs.
     */
    public void setFallbackGlyphIndex(final int value) {
        nSetFallbackGlyphIndex(value);
    }

    private native int nGetFallbackGlyphIndex(); /*
        return THIS->FallbackGlyphIndex;
    */

    private native void nSetFallbackGlyphIndex(int value); /*
        THIS->FallbackGlyphIndex = value;
    */

    /**
     * Ascent: distance from top to bottom of e.g. 'A' [0..FontSize] (unscaled).
     */
    public float getAscent() {
        return nGetAscent();
    }

    /**
     * Ascent: distance from top to bottom of e.g. 'A' [0..FontSize] (unscaled).
     */
    public void setAscent(final float value) {
        nSetAscent(value);
    }

    private native float nGetAscent(); /*
        return THIS->Ascent;
    */

    private native void nSetAscent(float value); /*
        THIS->Ascent = value;
    */

    public float getDescent() {
        return nGetDescent();
    }

    public void setDescent(final float value) {
        nSetDescent(value);
    }

    private native float nGetDescent(); /*
        return THIS->Descent;
    */

    private native void nSetDescent(float value); /*
        THIS->Descent = value;
    */

    /**
     * Approximate texture surface cost of this baked font.
     */
    public int getMetricsTotalSurface() {
        return nGetMetricsTotalSurface();
    }

    /**
     * Approximate texture surface cost of this baked font.
     */
    public void setMetricsTotalSurface(final int value) {
        nSetMetricsTotalSurface(value);
    }

    private native int nGetMetricsTotalSurface(); /*
        return THIS->MetricsTotalSurface;
    */

    private native void nSetMetricsTotalSurface(int value); /*
        THIS->MetricsTotalSurface = value;
    */

    public int getLastUsedFrame() {
        return nGetLastUsedFrame();
    }

    public void setLastUsedFrame(final int value) {
        nSetLastUsedFrame(value);
    }

    private native int nGetLastUsedFrame(); /*
        return THIS->LastUsedFrame;
    */

    private native void nSetLastUsedFrame(int value); /*
        THIS->LastUsedFrame = value;
    */

    public int getBakedId() {
        return nGetBakedId();
    }

    public void setBakedId(final int value) {
        nSetBakedId(value);
    }

    private native int nGetBakedId(); /*
        return THIS->BakedId;
    */

    private native void nSetBakedId(int value); /*
        THIS->BakedId = value;
    */

    public ImFont getOwnerFont() {
        return new ImFont(nGetOwnerFont());
    }

    public void setOwnerFont(final ImFont value) {
        nSetOwnerFont(value.ptr);
    }

    private native long nGetOwnerFont(); /*
        return (uintptr_t)THIS->OwnerFont;
    */

    private native void nSetOwnerFont(long value); /*
        THIS->OwnerFont = reinterpret_cast<ImFont*>(value);
    */

    public void clearOutputData() {
        nClearOutputData();
    }

    private native void nClearOutputData(); /*
        THIS->ClearOutputData();
    */

    public ImFontGlyph findGlyph(final int c) {
        return new ImFontGlyph(nFindGlyph(c));
    }

    private native long nFindGlyph(int c); /*
        return (uintptr_t)THIS->FindGlyph((ImWchar)c);
    */

    public ImFontGlyph findGlyphNoFallback(final int c) {
        return new ImFontGlyph(nFindGlyphNoFallback(c));
    }

    private native long nFindGlyphNoFallback(int c); /*
        return (uintptr_t)THIS->FindGlyphNoFallback((ImWchar)c);
    */

    public float getCharAdvance(final int c) {
        return nGetCharAdvance(c);
    }

    private native float nGetCharAdvance(int c); /*
        return THIS->GetCharAdvance((ImWchar)c);
    */

    public boolean isGlyphLoaded(final int c) {
        return nIsGlyphLoaded(c);
    }

    private native boolean nIsGlyphLoaded(int c); /*
        return THIS->IsGlyphLoaded((ImWchar)c);
    */

    /*JNI
        #undef THIS
     */
}
