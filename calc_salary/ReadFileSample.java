import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/*
 *   WorkingResult.csv（一か月分の勤務実績ファイル）を読み込み、各日の労働時間を計算して出力する処理です。
 *   このサンプルではWorkingResult.csvを「C:\WorkSpace」直下に配置して実行する前提になっています。
 *   ディレクトリの名前や配置場所が違う場合は WORKING_RESULT_FILE_PATH の値を適切なものに変更してください。
 */

public class ReadFileSample {
	public static void main(String[] args) {

		//  WorkingResult.csvのパス ※「C:\WorkSpace」直下に配置していない場合は適宜変更してください。
		final String WORKING_RESULT_FILE_PATH = "C:\\WorkSpace\\Java.El\\Practice\\Test2\\WorkingResult.csv";
		// コンマ
		final String COMMA = ","; 

		// 計算用の数値を定数で用意
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1分のミリ秒換算
		final int  ONE_HOUR_BY_MIN       = 60;             // 1時間の分換算


		List<String> workingResults = new ArrayList<String>(); //ファイルから読み込んだデータを格納しておくArrayList

		//  WorkingResult.csvを読み込む
		try {
			// WorkingResult.csvの読み込み準備
			File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
			BufferedReader br = new BufferedReader(new FileReader(workingResultFile));

			// WorkingResult.csvを1行ずつ読み込んでArrayListに格納する
			String recode = br.readLine();
			while (recode != null) {
				workingResults.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		int sum_paycheck = 0; //for文の最後に使うsum_paycheckの初期化
		// ArrayListから1行ずつ取り出して日付/出勤時間/退勤時間に振り分け
		for (int i = 0; i < workingResults.size() ; i++) {

			String workingRecode    = workingResults.get(i);      // 1行ずつ文字列を取り出す
			String[] forSplitRecode = workingRecode.split(COMMA); // splitメソッドを用いてカンマ区切りで文字列を分解＆配列にそれぞれ格納

			Date workingDate = Date.valueOf(forSplitRecode[0]); // 出勤日
			Time startTime   = Time.valueOf(forSplitRecode[1]); // 出勤時間
			Time finishTime  = Time.valueOf(forSplitRecode[2]); // 退勤時間

			// getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
			long workingTime = finishTime.getTime() - startTime.getTime();
			
			int day_wtm = (int)(workingTime/ONE_MIN_BY_MILLI_SEC) ; //働いた時間を分のみで表示
		
			// ミリ秒で取得した労働時間を○時間△分の形式に直す
			int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // 時間に換算
			int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // 分に換算
			
			int real_wtm = 0; //real_wtmの初期化
			int paycheck = 0; //paycheckの初期化
			int paycheckPerHour = 900 ;
			double paycheckPerMin = paycheckPerHour/60 ;
			
			if((6<=workingHour) && (workingHour<8)){		
				real_wtm = day_wtm - 45 ;
				paycheck = (int)Math.floor(real_wtm * paycheckPerMin) ;
				
			}else if( 8<=workingHour ){
				real_wtm = day_wtm - 60 ;
				
				if( real_wtm>8*60 ){
					int zngy_min = real_wtm - 8*60 ;
					paycheck = (int)Math.floor( 8*60*paycheckPerMin ) + (int)Math.floor( zngy_min*paycheckPerMin*1.25 ) ;
					
				}else{
					paycheck = (int)Math.floor( real_wtm*paycheckPerMin ) ;
				}
				
			}else{
				real_wtm = day_wtm ;
				paycheck = (int)Math.floor(real_wtm * paycheckPerMin) ;
			}
			
			sum_paycheck = sum_paycheck + paycheck ;
			
		}
		
		System.out.println("今月のお給料は" + sum_paycheck + "円です。");
		System.out.println( "今月もお疲れ様でした。");
	}
}

