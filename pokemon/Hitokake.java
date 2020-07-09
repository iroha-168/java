
class Hitokake extends Monster3{
	//-----フィールド-----
		//なし
	
	//-----コンストラクタ-----
	//コンストラクタ①
	Hitokake(){
		super();
		super.setCharacter("ヒトカケ");
	}
	
	//コンストラクタ②
	Hitokake( String tr,String nm ){
		super(tr,nm);
		super.setCharacter("ヒトカケ");
	}
		
	//コンストラクタ③
	Hitokake( String tr,String nm,int initial_lv ){
		super(tr,nm,initial_lv);
		super.setCharacter("ヒトカケ");
	}
	
	//-----メソッド-----
	//levelUpメソッドをオーバーライド
	public void levelUp( int lv_up ){
		if( lv_up == 0 ){
			//処理なし
		}else if( lv_up > 0 ){
			super.setLv( super.getLv() + lv_up*1 );
			super.setHp_max( super.getHp_max() + lv_up*14 );
			super.setAtk( super.getAtk() + lv_up*8 );
			super.setDef( super.getDef() + lv_up*5 );
			super.setSpd( super.getSpd() + lv_up*9 );
			super.setHp( super.getHp_max() );
		}
	}
}

