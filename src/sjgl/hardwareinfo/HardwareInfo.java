package sjgl.hardwareinfo;

public class HardwareInfo {
	public static final int cpuCores = Runtime.getRuntime().availableProcessors();
	public static final String cpuArchitecture = System.getenv("PROCESSOR_ARCHITECTURE");
	public static final String cpuIdentifier = System.getenv("PROCESSOR_IDENTIFIER");
	public static long freeMemory = Runtime.getRuntime().freeMemory();
	public static long maxMemory = Runtime.getRuntime().maxMemory();
	public static long totalMemory = Runtime.getRuntime().totalMemory();
}
