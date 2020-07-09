import java.math.BigDecimal;

class Monster1{
	//-------フィールド-----------
	String character = "(unknown)";    //種族
	String trainer = "(wild)";         //トレーナー
	String name = "(noname)";          //なまえ
	int lv = 1;                        //レベル
	int hp = 30;                       //HP
	int atk = 15;                      //こうげき
	int def = 10;                      //ぼうぎょ
	int spd = 10;                      //すばやさ
	int hp_max = 30;                   //HP初期値
	String waza_nm = "たいあたり";     //わざ（なまえ）
	String waza_dmg_rate = "1.0";      //わざ（ダメージ倍率）
	
	//--------メソッド---------
	//toStringメソッド
	public String toString(){
		return "character:" + character + "/" + "trainer:" + trainer + "/" + "name:" + name + "/" + "lv:" + lv + "/" + "hp:" + lv + "/" + "atk:" + atk + "/" + "def:" + def + "/" + "spd:" + spd + "/" + "hp_max:" + hp_max + "/" + "waza_nm:" + waza_nm + "/" + "waza_dmg_rate:" + waza_dmg_rate ;
	}
	
	//levelUpメソッド
	public void levelUp( int lv_up ){
		if( lv_up == 0){
			//処理なし
		}else if( lv_up > 0 ){
			lv = lv + lv_up * 1;
			hp_max = hp_max + lv_up * 15;
			atk = atk + lv_up * 5;
			def = def + lv_up * 5;
			spd = spd + lv_up * 5;
			hp = hp_max;
		}
	}
	
	//setWazaメソッド
	public void setWaza( String wz_nm, String wz_dg_rt ){
		String str = wz_dg_rt ;
		
		if( str.matches("^[0-9]+\.[0-9]$")){
			waza_nm = wz_nm;
			waza_dmg_rate = wz_dg_rt;
		}else{
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	//getStatusメソッド
	public String getStatus(){
		String resultMessage = "[" + name + "lv" + lv + "HP" + hp + "/" + hp_max + "]" ;
		return resultMessage ;
	}
	
	//useWazaメソッド
	public int useWaza(){
		BigDecimal a = BigDecimal.valueOf(atk);
		BigDecimal w = new BigDecimal(waza_dmg_rate);
		BigDecimal give_dmg = (a.multiply(w)).setScale(0,BigDecimal.ROUND_DOWN);
		
		int result_give_dmg = give_dmg.intValue();
		
		return result_give_dmg;
	}
	
	//damagedメソッド
	public int damaged(int gv_dmg){
		//ダメージ減算率を求める
		BigDecimal one = new BigDecimal("1");
		BigDecimal hun_twny = new BigDecimal("120");
		BigDecimal df = BigDecimal.valueOf(def);
		BigDecimal denom = one.add(df.divide(hun_twny));
		BigDecimal given_dmg_rate = one.divide(denom,2,BigDecimal.ROUND_UP);
		
		//実際に受けるダメージを求める
		BigDecimal gd = BigDecimal.valueOf(gv_dmg);
		BigDecimal given_dmg = gd.multiply(given_dmg_rate);
		int result_given_dmg = given_dmg.intValue();
		
		//HPの変化
		if( hp > result_given_dmg ){
			hp = hp - result_given_dmg;
		}else{
			hp = 0;
		}
		return result_given_dmg;
	}
}

