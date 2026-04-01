package imgui.extension.implot.flag;





public final class ImPlotCond {
    private ImPlotCond() {
    }

    /**
     * No condition (always set the variable), same as _Always
     *
     * <p>Definition: {@code ImGuiCond_None}
     */
    public static final int None = 0;

    /**
     * No condition (always set the variable)
     *
     * <p>Definition: {@code ImGuiCond_Always}
     */
    public static final int Always = 1;

    /**
     * Set the variable once per runtime session (only the first call will succeed)
     *
     * <p>Definition: {@code ImGuiCond_Once}
     */
    public static final int Once = 2;
}
