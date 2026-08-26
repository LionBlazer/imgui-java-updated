package imgui;

import imgui.binding.ImGuiStruct;

import java.nio.ByteBuffer;

/**
 * Renderer-facing texture data owned by Dear ImGui.
 */
public final class ImTextureData extends ImGuiStruct {
    public ImTextureData(final long ptr) {
        super(ptr);
    }

    /*JNI
        #include "_common.h"
        #define THIS ((ImTextureData*)STRUCT_PTR)
     */

    public int getStatus() {
        return nGetStatus();
    }

    private native int nGetStatus(); /*
        return THIS->Status;
    */

    public long getTexID() {
        return nGetTexID();
    }

    private native long nGetTexID(); /*
        return THIS->TexID;
    */

    public int getFormat() {
        return nGetFormat();
    }

    private native int nGetFormat(); /*
        return THIS->Format;
    */

    public int getWidth() {
        return nGetWidth();
    }

    private native int nGetWidth(); /*
        return THIS->Width;
    */

    public int getHeight() {
        return nGetHeight();
    }

    private native int nGetHeight(); /*
        return THIS->Height;
    */

    public int getBytesPerPixel() {
        return nGetBytesPerPixel();
    }

    private native int nGetBytesPerPixel(); /*
        return THIS->BytesPerPixel;
    */

    public int getUnusedFrames() {
        return nGetUnusedFrames();
    }

    private native int nGetUnusedFrames(); /*
        return THIS->UnusedFrames;
    */

    public int getRefCount() {
        return nGetRefCount();
    }

    private native int nGetRefCount(); /*
        return THIS->RefCount;
    */

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
