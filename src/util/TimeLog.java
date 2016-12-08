package util;

public class TimeLog {
	
	private long starttime, lasttime;
	
	
	private TimeLog(long time) {
		this.starttime = time;
		this.lasttime = time;
	}
	
	public static TimeLog start() {
		System.out.println("+0ms");
		return new TimeLog(System.currentTimeMillis());
	}
	
	public TimeLog addSplit() {
		long currenttime = System.currentTimeMillis();
		System.out.println("+" + (currenttime - lasttime) + "ms");
		lasttime = currenttime;
		return this;
	}
	
	public void end() {
		long currenttime = System.currentTimeMillis();
		System.out.println("+" + (currenttime - lasttime) + "ms");		
		System.out.println("TOTAL TIME: " + (currenttime - starttime) + "ms");
	}
}
