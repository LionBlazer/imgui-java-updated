package imgui.flag;

/** Texture lifecycle states exchanged with a renderer backend. */
public final class ImTextureStatus {
    private ImTextureStatus() {
    }

    public static final int OK = 0;
    public static final int Destroyed = 1;
    public static final int WantCreate = 2;
    public static final int WantUpdates = 3;
    public static final int WantDestroy = 4;
}
