import java.math.BigDecimal;

class Monster3{
	//------フィールド------
	private String character;          //種族
	private String trainer;            //トレーナー
	private String name;               //なまえ
	private int lv;                    //レベル
	private int hp;                    //HP
	private int atk;                   //こうげき
	private int def;                   //ぼうぎょ
	private int spd;                   //すばやさ
	private int hp_max;                //HP初期値
	private String waza_nm;            //わざ（なまえ）
	private String waza_dmg_rate;       //わざ（ダメージ倍率）

	//------コンストラクタ-------
	//コンストラクタ①
	Monster3(){
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
	Monster3( String tr,String nm ){
		this();
		this.trainer = tr;
		this.name = nm;
	}
	
	//コンストラクタ③
	Monster3( String tr,String nm,int initial_lv ){
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
			this.lv = lv + lv_up * 1;
			this.hp_max = hp_max + lv_up * 15;
			this.atk = atk + lv_up * 5;
			this.def = def + lv_up * 5;
			this.spd = spd + lv_up * 5;
			this.hp = hp_max;
		}
	}
	
	//setWazaメソッド
	public void setWaza( String wz_nm, String wz_dg_rt ){
		String str = wz_dg_rt ;
		
		if( str.matches("^[0-9]+\\.[0-9]$")){
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
			this.hp = hp - result_given_dmg;
		}else{
			this.hp = 0;
		}
		return result_given_dmg;
	}
	
	//-----getter/setter-----
	//String character
	public String getCharacter(){
		return this.character;
	}
	public void setCharacter( String character ){
		this.character = character;
	}
	
	//String trainer
	public String getTrainer(){
		return this.trainer;
	}
	public void setTrainer( String trainer ){
		this.trainer = trainer;
	}
	
	//String name
	public String getName(){
		return this.name;
	}
	public void setName( String name ){
		this.name = name;
	}
	
	//int lv
	public int getLv(){
		return this.lv;
	}
	public void setLv( int lv ){
		this.lv = lv;
	}
	
	//int hp
	public int getHp(){
		return this.hp;
	}
	public void setHp( int hp ){
		this.hp = hp;
	}
	
	//int atk
	public int getAtk(){
		return this.atk;
	}
	public void setAtk( int atk ){
		this.atk = atk;
	}
	
	//int def
	public int getDef(){
		return this.def;
	}
	public void setDef( int def ){
		this.def = def;
	}
	
	//int spd
	public int getSpd(){
		return this.spd;
	}
	public void setSpd( int spd ){
		this.spd = spd;
	}
	
	//int hp_max
	public int getHp_max(){
		return this.hp_max;
	}
	public void setHp_max( int hp_max ){
		this.hp_max = hp_max;
	}
	
	//String waza_nm
	public String getWaza_nm(){
		return this.waza_nm;
	}
	public void setWaza_nm( String waza_nm ){
		this.waza_nm = waza_nm;
	}
	
	//String waza_dmg_rate
	public String getWaza_dmg_rate(){
		return this.waza_dmg_rate;
	}
	public void setWaza_dmg_rate( String waza_dmg_rate ){
		this.waza_dmg_rate = waza_dmg_rate;
	}
	
}
