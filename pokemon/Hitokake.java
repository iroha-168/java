
class Hitokake extends Monster3{
	//-----�t�B�[���h-----
		//�Ȃ�
	
	//-----�R���X�g���N�^-----
	//�R���X�g���N�^�@
	Hitokake(){
		super();
		super.setCharacter("�q�g�J�P");
	}
	
	//�R���X�g���N�^�A
	Hitokake( String tr,String nm ){
		super(tr,nm);
		super.setCharacter("�q�g�J�P");
	}
		
	//�R���X�g���N�^�B
	Hitokake( String tr,String nm,int initial_lv ){
		super(tr,nm,initial_lv);
		super.setCharacter("�q�g�J�P");
	}
	
	//-----���\�b�h-----
	//levelUp���\�b�h���I�[�o�[���C�h
	public void levelUp( int lv_up ){
		if( lv_up == 0 ){
			//�����Ȃ�
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
