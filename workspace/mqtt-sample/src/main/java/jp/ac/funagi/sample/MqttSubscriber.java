package jp.ac.funagi.sample;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class MqttSubscriber {
	private static final String BROKER_URL
	= "tcp://broker.emqx.io:1883";
	private static final String TOPIC
	= "paho/sample";
	private static final String CLIENT_ID
	= "subscribe-sample-iot01";
	private static final int QOS = 1;
	
    // ★追加: JacksonのMapperオブジェクトを定義
    private static final ObjectMapper objectMapper = new ObjectMapper();

	
	public static void main(String[] args) {
	        MqttClient client = null;

	        try {
	            client = new MqttClient(BROKER_URL, CLIENT_ID);

	            MqttConnectOptions options = new MqttConnectOptions();
	            options.setCleanSession(true);
	            options.setAutomaticReconnect(true);

	            System.out.println("MQTTサブスクライバーを起動しました");
	            System.out.println("ブローカーに接続中... " + BROKER_URL
	                    + " クライアントID: " + CLIENT_ID);
	            client.connect(options);
	            System.out.println("接続しました");
//====↓Publisherと異なる部分============================
	            
	            // サブスクライブ処理の記述（非同期コールバック）
	            client.subscribe(TOPIC, QOS,
//	            		=======別のスレッドが立ち上がり非同期に実行される処理＝＝＝＝＝
	            		(topic, message) -> {
//	           .subscribeメソッドもいろいろな引数でオーバーロードされている。
//	            	.subscribe自体は、トピックに参加するだけのメソッド。
//	            	届いたメッセージを読み込む処理は第三引数のラムダ式で「非同期」に行われている。
	            	
//	            	◆第三引数のラムダ式は、
//	            	org.eclipse.paho.client.mqttv3.IMqttMessageListener
//	            	特定のトピックにメッセージが届いた（受信した）際に呼び出されるコールバック処理を
//	            	定義するための関数型インターフェース。
//	            	中では↓のメソッドが一つだけ定義されている。通常匿名クラスかラムダ式で処理を書く。
//	            	void messageArrived(String topic, MqttMessage message) 
//	            	throws Exception
//	            	• 引数:
//	            		• topic: メッセージが届いた実際のトピック名。
//	            		• message: 受信したメッセージのペイロード（データ本体）やQoS、
//	            			リテインフラグなどの情報を含む MqttMessage オブジェクト。
	            	
//	                // ここで受信用処理を行います（Phase 1-2Bで実装）
//	            	// 受信ペロード（バイト配列）の取得
//	                byte[] payload = message.getPayload();
//	                // バイト配列を UTF-8 文字列に復元
//	                String text = new String(payload, StandardCharsets.UTF_8);
//	             // 2. 届いたトピック名と中身を表示（非同期で実行される）
//	                System.out.println("【受信】 トピック: " + topic);
//	                System.out.println("【内容】 メッセージ: " + payload);
	                
//	             // --- 【変更前】ステップ1（コールバック内） ---
//	                byte[] payload = message.getPayload();
//	                String text = new String(payload, StandardCharsets.UTF_8);
//	                System.out.println("メッセージを受信しました: " + text);

	                // --- 【変更後】ステップ3（コールバック内） ---
	                byte[] jsonBytes = message.getPayload();
	                System.out.println("メッセージを受信しました: " 
	                + new String(jsonBytes, StandardCharsets.UTF_8));

//	      =====.readValueメソッドはデシリアライズに失敗すると、 
//	                throws JacksonExceptionを投げるので、そのエラーを検知する処理 try-catch
//	                を書くサイレントエラーにしないために============
	                // ★追加: JSONバイト配列からJavaオブジェクトへ復元（デシリアライズ）
	                try {
						MessageData data 
						= objectMapper.readValue(jsonBytes, MessageData.class);
						String str
						= new String(jsonBytes);
						System.out.println(
								"JSONをメッセージデータに変換（デシリアライズ）しました: " + data);
						System.out.println("Stringで受信"+str);

						 System.out.println(
								 "動いているスレッド名: " + Thread.currentThread().getName());
					} catch (JacksonException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
						System.out.println("catchしたスレッド: " + Thread.currentThread().getName());
					}
	            }
//==============別スレッドの中で行われる処理ここまで。
	            		);

	            System.out.println("トピックを購読中: " + TOPIC);

//	            =============↓をコメントアウトして実行すると、
//	            （待機処理がないため）try ブロックの終点に一瞬で到達してしまう===========
	            
	            // アプリケーションが即座に終了しないよう待機ループを作成
	            try (Scanner scanner = new Scanner(System.in)) {
	                while (true) {
	                    System.out.println("終了するには 'exit' と入力してください\n：");
	                    String input = scanner.nextLine();
	                    if (input.equalsIgnoreCase("exit")) {
	                        break;
	                    }
	                }
	            }
//	            ==================コメントアウトテストここまで
	            
	        } catch (MqttException e) {
	            e.printStackTrace();
	        } finally {
	            // （切断処理は Publisher と同様）
	            if (client != null) {
	                try {
	                    if (client.isConnected()) {
	                        System.out.println("ブローカーから切断中...");
	                        client.disconnect();
	                        System.out.println("切断しました");
	                    }
	                } catch (MqttException e) {
	                    System.err.println("切断中にエラーが発生しました: " + e.getMessage());
	                }

	                try {
	                    System.out.println("クライアントリソースを開放中...");
	                    client.close();
	                    System.out.println("リソースを開放しました");
	                } catch (MqttException e) {
	                    System.err.println("クライアントリソースの開放中にエラーが発生しました: "
	                            + e.getMessage());
	                }
	            }
	        }
	    }
}	
//
//質問の前提に一つ誤解があるので、そこから説明します。例外はメインスレッドでは表示されていません。 別スレッドの中で捕まえられ、別スレッドがそのまま画面に出しています。メインスレッドは何もしていません。
//
//証拠はスタックトレースにあります
//スタックトレースは下から上に読みます。いちばん下が、そのスレッドの出発点です。
//
//at java.base/java.lang.Thread.run(Thread.java:1583)          ← 出発点：Pahoが作ったスレッド
//at ...paho...CommsCallback.run(CommsCallback.java:214)        ← Pahoの配信係
//at ...paho...CommsCallback.deliverMessage(...)
//at jp.ac.funagi.sample.MqttSubscriber.lambda$0(MqttSubscriber.java:88)  ← あなたのラムダ式
//at tools.jackson.databind.ObjectMapper.readValue(...)         ← ここで例外が発生
//
//main という行がどこにもありません。もしメインスレッドで起きた例外なら、いちばん下は MqttSubscriber.main(...) になるはずです。つまり、例外は「MQTT Call」スレッドの中で起き、同じスレッドの中の catch で捕まり、同じスレッドが printStackTrace() を実行しています。
//
//混乱しやすい点：「書いた場所」と「実行するスレッド」は別
//try-catchは、ソースコード上は main メソッドの中に書かれています。ですが、そこで行われているのはラムダ式という「処理の中身」をPahoに渡すことだけです。その場では実行されません。
//
//たとえるなら、メインスレッドは「手紙が届いたら、この手順書どおりに処理して。失敗したら記録して」というメモを書いて、配達係に預けただけです。実際に手紙を開けて、失敗したら記録をつけるのは配達係です。メモを書いた人ではありません。
//
//メモ ＝ ラムダ式（正確には IMqttMessageListener の実装オブジェクト）
//預ける ＝ client.subscribe(...) で登録すること
//配達係 ＝ Pahoが内部で作ったスレッド（MQTT Call: subscribe-sample-iot01）
//
//メッセージが届くと、配達係のスレッドが messageArrived(topic, message)、つまりラムダ式の中身を呼び出します。try-catchはラムダ式の内側にあるので、配達係のスレッドの中で動きます。
//
//では、なぜ同じ画面に出るのか
//画面（コンソール）は、プログラム全体で1つの共有の掲示板だからです。System.out も System.err も、プロセス全体で1つだけです（printStackTrace() は System.err に書きます）。どのスレッドが書いても同じ掲示板に貼られるので、メインスレッドが表示しているように見えます。
//
//ちなみに、そのときメインスレッドは scanner.nextLine() で、キーボード入力を待って止まっています。実行結果の「：」がその待機中の表示です。
//
//逆に、別スレッドの例外はメインスレッドでは捕まえられない
//ここが一番大事な点です。main の外側にある catch (MqttException e) は、ラムダ式の中で起きた例外を捕まえられません。例外は、それが起きたスレッドの呼び出しの流れ（コールスタック）をさかのぼるだけで、他のスレッドには伝わらないからです。
//
//だから、ラムダ式の内側にtry-catchを書いたのは正しい判断です。もし書いていなければ、例外はPahoの配信係のところまで上がっていきます。Paho v3は、messageArrived が例外を投げるとクライアントを停止させる作りだったと記憶しています。その場合、変なメッセージが1通来ただけで接続が切れてしまいます。
//
//まとめ
//
//ラムダ式は main の中に書いてあっても、実行するのはPahoのスレッドです。
//例外は、起きたスレッドの中でしか伝わりません。だから受信処理の中にcatchが必要です。
//画面はプログラム全体で共有なので、どのスレッドの出力も同じところに出ます。
//
//確かめたいときは、catch の中にも System.out.println("catchしたスレッド: " + Thread.currentThread().getName()); を足して実行してみてください。main ではなく MQTT Call: ... と表示されるはずです。
//
//コンパイラは、どのスレッドで動くかを見ていません。コンパイルが通る理由は2つあり、どちらもスレッドとは関係ありません。
//
//理由1：Jackson 3の JacksonException は非チェック例外
//import文が tools.jackson... になっているので、使っているのはJackson 3です。Jackson 3では、例外のおおもとの JacksonException が RuntimeException を継承するように変わりました。
//
//非チェック例外（RuntimeException の仲間）は、catchしなくてもコンパイラは何も言いません。
//メソッドの宣言に throws JacksonException と書いてあっても、それは「この例外が起きることがあります」という説明書きにすぎません。処理を強制するものではありません。
//
//ちなみに、Jackson 2では同じ役割の JsonProcessingException が IOException を継承していて、チェック例外でした。古い記事でtry-catchが必須のように書かれているのは、そのためです。
//
//理由2：チェック例外だったとしても、ラムダ式の外には出てこない
//仮にチェック例外だったとしても、main でcatchする必要はありません。コンパイラが確かめているのは、例外が出ていく先のメソッドが throws で許しているかだけです。
//
//ラムダ式の中身は、IMqttMessageListener の messageArrived メソッドになります。
//このメソッドは void messageArrived(String topic, MqttMessage message) throws Exception と宣言されています。
//つまり、「中でどんな例外が起きても、外に投げてよい」と宣言済みです。だから、ラムダ式の中にcatchがなくてもコンパイルは通ります。
//main はラムダ式を「渡している」だけで、「呼び出して」はいません。なので、main 側に例外を処理する義務は生じません。
//
//比べてみると分かりやすい例
//Thread.sleep() は、チェック例外の InterruptedException を投げます。
//
//java
//// ① Pahoのラムダ式の中：コンパイルが通る（messageArrived が throws Exception だから）
//client.subscribe(TOPIC, QOS, (topic, message) -> {
//    Thread.sleep(100);
//});
//
//// ② new Thread のラムダ式の中：コンパイルエラー
//new Thread(() -> {
//    Thread.sleep(100);   // Runnable の run() には throws が付いていないため
//}).start();
//
//どちらも別スレッドで動く処理です。それでも結果が違うのは、コンパイラがインターフェースのメソッド宣言（throws の有無）だけを見ているからです。スレッドかどうかは関係ありません。
//
//まとめ
//
//今回コンパイルが通るのは、主にJackson 3の例外が非チェック例外だからです。
//ラムダ式の中のチェック例外を許すかどうかは、そのラムダ式が実装するインターフェースの throws で決まります。
//コンパイラはスレッドを意識しません。どのスレッドで動くかは、実行時に初めて決まることだからです。
//
//非チェック例外はcatchしなくてもコンパイルが通るぶん、書き忘れても気付きにくいです。まさんのように、意識してtry-catchを書いておくのが安全です。
//
//このメソッドは void messageArrived(String topic, MqttMessage message) throws Exception と宣言されています。
//
//、、、だめだな、、、javaの文法は記憶が曖昧な所が多いな、、、。復習などの自主学習時間が足りていない。関数型インターフェースをラムダ式で実装したときに、例外を投げる、throwsは書かなくてよいのだっけ？宣言と呼び出しは異なる感じ？だっけ？インターフェースの実装のところの知識があやふやだなこれは、、、。
//
//曖昧になりやすいところなので、気にしすぎなくて大丈夫です。順番に整理します。
//
//答え：ラムダ式には throws を書けません（書かなくてよい、ではなく、書く場所がない）
//ラムダ式には、メソッド名も戻り値の型も throws も書く場所がありません。その代わり、実装する関数型インターフェースのメソッド宣言を、そのまま引き継ぎます。
//
//java
//// Pahoのインターフェース（宣言）
//public interface IMqttMessageListener {
//    void messageArrived(String topic, MqttMessage message) throws Exception;
//}
//
//// ラムダ式（実装）：引数と中身だけを書く
//(topic, message) -> { ...中身... }
//// コンパイラはこれを「throws Exception 付きの messageArrived の実装」として扱う
//
//3つの立場に分けると整理しやすいです
//契約書にたとえます。
//
//立場	今回のコード	例外についての役割
//宣言（契約書）	IMqttMessageListener の messageArrived(...) throws Exception	「このメソッドは例外を投げることがある」と決める
//実装（契約を守る側）	まさんが書いたラムダ式	宣言の範囲内なら、例外を外に投げてよい
//呼び出し（契約を使う側）	Paho内部の CommsCallback	宣言に throws がある以上、呼び出す側がcatchする義務を負う
//
//チェック例外の処理を強制されるのは、呼び出す側です。今回それはPahoの内部なので、まさんのコードではなくPahoのコードがcatchを書いています。まさんの main は、実装（ラムダ式）を渡しているだけで、呼び出してはいません。だから義務がありません。
//
//匿名クラスで書くと、隠れている部分が見えます
//ラムダ式は、匿名クラスの省略形です。
//
//java
//client.subscribe(TOPIC, QOS, new IMqttMessageListener() {
//    @Override
//    public void messageArrived(String topic, MqttMessage message) throws Exception {
//        // 中身
//    }
//});
//
//匿名クラスでは throws を書けます。書くかどうかは選べますが、ルールが1つあります。
//
//宣言より狭くするのはOK：throws Exception を省略する、throws IOException に絞る、など
//宣言より広くするのはNG：宣言にない種類のチェック例外を投げることはできない
//
//ラムダ式は、この「throws 部分」を書かずに、宣言どおりの範囲を自動で使う、と覚えてください。
//
//一行でまとめると
//
//例外を投げてよいかどうかは、インターフェースの宣言で決まる
//例外の処理を強制されるのは、そのメソッドを呼び出す側
//ラムダ式は、宣言の throws をそのまま引き継ぐ（自分では書けない）
//
//復習の時間が足りないと感じるのは自然です。それに、今日のように「自分の書いたコードで、なぜこうなるのか」を突き詰めるのは、とても良い復習になっています。文法書を読み直すより記憶に残りやすいやり方だと思います。