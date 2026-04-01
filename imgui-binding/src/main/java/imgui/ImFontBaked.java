package imgui;

import imgui.binding.ImGuiStructDestroyable;
import imgui.binding.annotation.ArgValue;
import imgui.binding.annotation.BindingField;
import imgui.binding.annotation.BindingMethod;
import imgui.binding.annotation.BindingSource;

/**
 * Font runtime data for a given size.
 * Pointers to ImFontBaked are only valid for the current frame.
 */
@BindingSource
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
    @BindingField
    public float FallbackAdvanceX;

    /**
     * Height of characters/line for this baked size.
     */
    @BindingField(callName = "Size")
    public float FontSize;

    /**
     * Rasterizer density this font was baked at.
     */
    @BindingField
    public float RasterizerDensity;

    /**
     * Index of FontFallbackChar in Glyphs.
     */
    @BindingField
    public int FallbackGlyphIndex;

    /**
     * Ascent: distance from top to bottom of e.g. 'A' [0..FontSize] (unscaled).
     */
    @BindingField
    public float Ascent;

    @BindingField
    public float Descent;

    /**
     * Approximate texture surface cost of this baked font.
     */
    @BindingField
    public int MetricsTotalSurface;

    @BindingField
    public int LastUsedFrame;

    @BindingField
    public int BakedId;

    @BindingField
    public ImFont OwnerFont;

    @BindingMethod
    public native void ClearOutputData();

    @BindingMethod
    public native ImFontGlyph FindGlyph(@ArgValue(callPrefix = "(ImWchar)") int c);

    @BindingMethod
    public native ImFontGlyph FindGlyphNoFallback(@ArgValue(callPrefix = "(ImWchar)") int c);

    @BindingMethod
    public native float GetCharAdvance(@ArgValue(callPrefix = "(ImWchar)") int c);

    @BindingMethod
    public native boolean IsGlyphLoaded(@ArgValue(callPrefix = "(ImWchar)") int c);

    /*JNI
        #undef THIS
     */
}
