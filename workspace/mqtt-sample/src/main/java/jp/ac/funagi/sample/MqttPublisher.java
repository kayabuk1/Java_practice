package jp.ac.funagi.sample;
//broker.emqx.io:1883 MQTTブローカー

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import tools.jackson.databind.ObjectMapper;

public class MqttPublisher {
    // 1. 定数定義
    private static final String BROKER_URL 
    	= "tcp://broker.emqx.io:1883";
//    
    private static final String TOPIC = "paho/sample";
//    サブスクライバーへのデータ送信に使うための部屋や掲示板ようなものを指定。
    private static final String CLIENT_ID = "publish-sample-iot01";
    private static final int QOS = 1;
//    「private static final」⇒Javaで定数を作るときのお決まりの修飾子
//    ⇒クラス全体で使う、変更できない定数（固定の値）
    
    // ★追加: JacksonのMapperオブジェクトを定義
    private static final ObjectMapper objectMapper = new ObjectMapper();
//    Jacksonの ObjectMapper は、JavaのオブジェクトとJSON形式のデータを相互に
//    簡単に変換（シリアライズ・デシリアライズ）するためのクラス


    public static void main(String[] args) {
        MqttClient client = null;
//        ↑tryの外で変数を宣言して、finally句でも参照出来る様にする。

        try {
            // 2. クライアントのインスタンス化
            client = new MqttClient(BROKER_URL, CLIENT_ID);
//            オブジェクトを作っただけでは、まだﾌﾞﾛｰｶとの接続は行われていない。

            // 3. 接続オプションの設定
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);       // 新規セッションとして開始
            options.setAutomaticReconnect(true); // 自動再接続を有効化
//            ↑のMQTTのオプションクラスは、ﾌﾞﾛｰｶと接続するときにどの様な
//            設定で行うのか決めるクラス。色々な設定メソッドがあるが代表的なものを
//            ２つだけ書いてあるとのこと。
//            options.set と打つとたくさんの setXXXオプションがあるのが分かる。

            System.out.println("MQTTパブリッシャーを起動しました");
            System.out.println("ブローカーに接続中... " + BROKER_URL
                    + " クライアントID: " + CLIENT_ID);
            
            // 4. ブローカーへ接続
            client.connect(options);
//            ↑特段設定したい項目がない場合は引数なしのコネクトメソッドもある。
            System.out.println("接続しました");
            
            // （Phase 1-1Aの接続処理直後に挿入）
            // --- メッセージ送信ループの追加 ---
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("送信するメッセージを入力してください"
                            + "（終了するには 'exit' と入力）: ");
                    String message = scanner.nextLine();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }

//                 // --- 【変更前】ステップ1（送信ループ内） ---
//                    byte[] payload = message.getBytes(StandardCharsets.UTF_8);
//                    MqttMessage mqttMessage = new MqttMessage(payload);

//                    // MQTTメッセージオブジェクトを作成しQoSを設定
//                    MqttMessage mqttMessage 
//                    	= new MqttMessage(payload);
//                    mqttMessage.setQos(QOS);
                    
                    // --- 【変更後】ステップ3（送信ループ内） ---
                    // A. データオブジェクトの生成
                    MessageData data 
                    = new MessageData(CLIENT_ID, message, LocalDateTime.now());
                    System.out.println("メッセージデータを作成しました: " + data);
                    System.out.println(
	            			 "動いているスレッド名: " + Thread.currentThread().getName());
                    
                 // B. JSONバイト配列への変換（シリアライズ）
//                 ↓Stringで送れるメソッドもあるが、今回はバイトMqttでバイトで送るため未使用。   
//                    objectMapper.writeValueAsString(data);
                    
                    byte[] jsonBytes = objectMapper.writeValueAsBytes(data);
                    System.out.println(
                    		"メッセージデータをJSONに変換（シリアライズ）しました: " 
                    + new String(jsonBytes, StandardCharsets.UTF_8));
                    System.out.println(
	            			 "動いているスレッド名: " + Thread.currentThread().getName());

                    // C. MqttMessageの作成と送信
                    MqttMessage mqttMessage = new MqttMessage(jsonBytes);

                    // 指定トピックへ送信
                    mqttMessage.setQos(QOS);
                    
                    client.publish(TOPIC, mqttMessage);
                    System.out.println("メッセージを送信しました");
                    System.out.println(
	            			 "動いているスレッド名: " + Thread.currentThread().getName());
                }
            }


        } catch (MqttException e) {
            e.printStackTrace();
        } finally {
            // 5. 堅牢な切断・リソース解放処理
            if (client != null) {
                try {
                    if (client.isConnected()) {
                        System.out.println("ブローカーから切断中...");
                        client.disconnect();
                        System.out.println("切断しました");
                    }
                } catch (MqttException e) {
                    System.err.println("切断中にエラーが発生しました: "
                            + e.getMessage());
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
