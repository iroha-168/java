import java.math.BigDecimal;

class Monster2{
	//------フィールド------
	String character;          //種族
	String trainer;            //トレーナー
	String name;               //なまえ
	int lv;                    //レベル
	int hp;                    //HP
	int atk;                   //こうげき
	int def;                   //ぼうぎょ
	int spd;                   //すばやさ
	int hp_max;                //HP初期値
	String waza_nm;            //わざ（なまえ）
	String waza_dmg_rate;       //わざ（ダメージ倍率）

	//------コンストラクタ-------
	//コンストラクタ①
	Monster2(){
		this.character = "(unknown)";
		this.trainer = "(wild)";
		this.name = "(noname)";
		this.lv = 1;
		this.hp = 30;
		this.atk = 15;
		this.def = 10;
		this.spd = 10;
		this.hp_max = 30;
		this.waza_nm = "たいあたり";
		this.waza_dmg_rate = "1.0";
	}
	
	//コンストラクタ②
	Monster2( String tr,String nm ){
		this();
		this.trainer = tr;
		this.name = nm;
	}
	
	//コンストラクタ③
	Monster2( String tr,String nm,int initial_lv ){
		this(tr,nm);
		levelUp(initial_lv - 1);
	}
	
	//------メソッド-------
	//toStringメソッド
	public String toString(){
		return "character:" + this.character + "/" + "trainer:" + this.trainer + "/" + "name:" + this.name + "/" + "lv:" + this.lv + "/" + "hp:" + this.lv + "/" + "atk:" + this.atk + "/" + "def:" + this.def + "/" + "spd:" + this.spd + "/" + "hp_max:" + this.hp_max + "/" + "waza_nm:" + this.waza_nm + "/" + "waza_dmg_rate:" + this.waza_dmg_rate ;
	}
	
	//levelUpメソッド
	public void levelUp( int lv_up ){
		if( lv_up == 0){
			//処理なし
		}else if( lv_up > 0 ){
			this.lv = this.lv + lv_up * 1;
			this.hp_max = this.hp_max + lv_up * 15;
			this.atk = this.atk + lv_up * 5;
			this.def = this.def + lv_up * 5;
			this.spd = this.spd + lv_up * 5;
			this.hp = this.hp_max;
		}
	}
	
	//setWazaメソッド
	public void setWaza( String wz_nm, String wz_dg_rt ){
		String str = wz_dg_rt ;
		
		if( str.matches("^[0-9]+\.[0-9]$")){
			this.waza_nm = wz_nm;
			this.waza_dmg_rate = wz_dg_rt;
		}else{
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	//getStatusメソッド
	public String getStatus(){
		String resultMessage = "[" + this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hp_max + "]" ;
		return resultMessage ;
	}
	
	//useWazaメソッド
	public int useWaza(){
		BigDecimal a = BigDecimal.valueOf(this.atk);
		BigDecimal w = new BigDecimal(this.waza_dmg_rate);
		BigDecimal give_dmg = (a.multiply(w)).setScale(0,BigDecimal.ROUND_DOWN);
		
		int result_give_dmg = give_dmg.intValue();
		
		return result_give_dmg;
	}
	
	//damagedメソッド
	public int damaged(int gv_dmg){
		//ダメージ減算率を求める
		BigDecimal one = new BigDecimal("1");
		BigDecimal hun_twny = new BigDecimal("120");
		BigDecimal df = BigDecimal.valueOf(this.def);
		BigDecimal denom = one.add(df.divide(hun_twny));
		BigDecimal given_dmg_rate = one.divide(denom,2,BigDecimal.ROUND_UP);
		
		//実際に受けるダメージを求める
		BigDecimal gd = BigDecimal.valueOf(gv_dmg);
		BigDecimal given_dmg = gd.multiply(given_dmg_rate);
		int result_given_dmg = given_dmg.intValue();
		
		//HPの変化
		if( this.hp > result_given_dmg ){
			this.hp = this.hp - result_given_dmg;
		}else{
			this.hp = 0;
		}
		return result_given_dmg;
	}
}
