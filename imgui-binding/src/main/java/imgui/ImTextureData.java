package imgui;

import imgui.binding.ImGuiStruct;
import imgui.binding.annotation.BindingField;
import imgui.binding.annotation.BindingSource;

import java.nio.ByteBuffer;

/**
 * Renderer-facing texture data owned by Dear ImGui.
 */
@BindingSource
public final class ImTextureData extends ImGuiStruct {
    public ImTextureData(final long ptr) {
        super(ptr);
    }

    /*JNI
        #include "_common.h"
        #define THIS ((ImTextureData*)STRUCT_PTR)
     */

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int Status;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public long TexID;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int Format;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int Width;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int Height;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int BytesPerPixel;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int UnusedFrames;

    @BindingField(accessors = BindingField.Accessor.GETTER)
    public int RefCount;

    public native int getUpdateX(); /*
        return THIS->UpdateRect.x;
    */

    public native int getUpdateY(); /*
        return THIS->UpdateRect.y;
    */

    public native int getUpdateWidth(); /*
        return THIS->UpdateRect.w;
    */

    public native int getUpdateHeight(); /*
        return THIS->UpdateRect.h;
    */

    /**
     * Returns a frame-scoped view of the native pixel storage without copying it.
     */
    public native ByteBuffer getPixels(); /*
        return env->NewDirectByteBuffer(THIS->GetPixels(), THIS->GetSizeInBytes());
    */

    public native void setTexID(long texId); /*
        THIS->SetTexID((ImTextureID)(intptr_t)texId);
    */

    public native void setStatus(int status); /*
        THIS->SetStatus((ImTextureStatus)status);
    */

    /*JNI
        #undef THIS
     */
}
