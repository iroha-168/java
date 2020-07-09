
class Fushigiyade extends Monster3{
	//-----フィールド-----
		//なし
	
	//-----コンストラクタ-----
	//コンストラクタ①
	Fushigiyade(){
		super();
		super.setCharacter("フシギヤデ");
	}
	
	//コンストラクタ②
	Fushigiyade( String tr,String nm ){
		super(tr,nm);
		super.setCharacter("フシギヤデ");
	}
		
	//コンストラクタ③
	Fushigiyade( String tr,String nm,int initial_lv ){
		super(tr,nm,initial_lv);
		super.setCharacter("フシギヤデ");
	}
	
	//-----メソッド-----
	//levelUpメソッドをオーバーライド
	public void levelUp( int lv_up ){
		if( lv_up == 0 ){
			//処理なし
		}else if( lv_up > 0 ){
			super.setLv( super.getLv() + lv_up*1 );
			super.setHp_max( super.getHp_max() + lv_up*16 );
			super.setAtk( super.getAtk() + lv_up*6 );
			super.setDef( super.getDef() + lv_up*7 );
			super.setSpd( super.getSpd() + lv_up*8 );
			super.setHp( super.getHp_max() );
		}
	}
}








