package chapter4_1;

public class Main {
//	補講：main関数に引数について

	public static void main(String[] args) {
		for (String s: args) {
			System.out.println(s);
		}
//		↑これで実行すると何も出てこない。
//		eclipse上で引数を指定して実行するには、
//		左メニューMain.java※このプログラムを右クリック
//		実行→実行の構成→引数のタブ→引数に渡す内容を
//		入力→ex:Hello Java world
//		引数が空白区切りで3つ渡され実行
////		結果：
//		Helllo
//		Java
//		World
//またはCMDからこのプログラムのある場所のフォルダに移動
//		C:\Users\iot01>cd /d d:
//		D:\>
//		C:\Users\iot01>cd /d
//		ファイル名、ディレクトリ名、またはボリューム ラベルの構文が間違っています。
//
//		C:\Users\iot01>cd /d d:
//
//		D:\>java Main
//		Error: A JNI error has occurred, please check your installation and try again
//		Exception in thread "main" java.lang.UnsupportedClassVersionError: Main has been compiled by a more recent version of the Java Runtime (class file version 65.0), this version of the Java Runtime only recognizes class file versions up to 52.0
//		        at java.lang.ClassLoader.defineClass1(Native Method)
//		        at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
//		        at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
//		        at java.net.URLClassLoader.defineClass(URLClassLoader.java:473)
//		        at java.net.URLClassLoader.access$100(URLClassLoader.java:74)
//		        at java.net.URLClassLoader$1.run(URLClassLoader.java:369)
//		        at java.net.URLClassLoader$1.run(URLClassLoader.java:363)
//		        at java.security.AccessController.doPrivileged(Native Method)
//		        at java.net.URLClassLoader.findClass(URLClassLoader.java:362)
//		        at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
//		        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:352)
//		        at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
//		        at sun.launcher.LauncherHelper.checkAndLoadMain(LauncherHelper.java:621)
//
//		D:\>java --version
//		Unrecognized option: --version
//		Error: Could not create the Java Virtual Machine.
//		Error: A fatal exception has occurred. Program will exit.
//
//		D:\>java -version
//		openjdk version "1.8.0_442"
//		OpenJDK Runtime Environment Corretto-8.442.06.1 (build 1.8.0_442-b06)
//		OpenJDK 64-Bit Server VM Corretto-8.442.06.1 (build 25.442-b06, mixed mode)
//		D:>"C:\pleiades\2025-09\java\21\bin\java.exe" Main
//		エラー: メイン・クラスMainを検出およびロードできませんでした
//		原因: java.lang.NoClassDefFoundError: Main (wrong name: chapter4_1/Main)
//
//
//		D:>"C:\pleiades\2025-09\java\21\bin\java.exe" chapter4_1/Main
//
//
//		D:>"C:\pleiades\2025-09\java\21\bin\java" chapter4_1/Main
//
//
//		D:>"C:\pleiades\2025-09\java\21\bin\java" chapter4_1/Main yahalo
//		yahalo
//
//
//		D:>"C:\pleiades\2025-09\java\21\bin\java.exe" chapter4_1/Main yahalo
//		yahalo
//
//
//		D:>"C:\pleiades\2025-09\java\21\bin\java.exe" chapter4_1/Main maromaro
//		maromaro
//
//
//		D:>"C:\pleiades\2025-09\java\21\bin\java.exe" chapter4_1.Main maromaro
//		maromaro
//
//
//		D:>
	}

}
