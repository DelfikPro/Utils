package implario.util;

import java.util.ArrayList;
import java.util.List;

public class Scheduler extends Thread{
	private static List<Task> tasks = new ArrayList<>();
	private int times = 0;
	private volatile static boolean started = true;

	public static void init(){
		new Scheduler().start();
	}

	@Override
	public void run() {
		while (started){
			sleep(100);
			if(++times == 101)times = 1;
			for(Task task : tasks)
				if(times % task.times == 0)task.run();
		}
	}

	public static void kill(){
		started = false;
	}

	public static void addTask(Task task){
		tasks.add(task);
	}

	public static void runThr(Runnable runnable){
		new Thread(){
			@Override
			public void run(){
				try{
					runnable.run();
				}catch (Throwable ignored){}
				this.stop();
			}
		}.start();
	}

	public static void sleep(int millis){
		try{
			Thread.sleep(millis);
		}catch (InterruptedException ex){
			throw new RuntimeException(ex);
		}
	}

	public static abstract class Task implements Runnable{
		private final int times;

		protected Task(int times){
			this.times = times;
		}
	}

	public static class RunTask extends Task{
		private final Runnable runnable;

		public RunTask(int times, Runnable runnable){
			super(times);
			this.runnable = runnable;
		}

		@Override
		public void run() {
			runnable.run();
		}
	}
}
