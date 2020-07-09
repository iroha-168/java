import java.math.BigDecimal;

class Monster2{
	//------�t�B�[���h------
	String character;          //�푰
	String trainer;            //�g���[�i�[
	String name;               //�Ȃ܂�
	int lv;                    //���x��
	int hp;                    //HP
	int atk;                   //��������
	int def;                   //�ڂ�����
	int spd;                   //���΂₳
	int hp_max;                //HP�����l
	String waza_nm;            //�킴�i�Ȃ܂��j
	String waza_dmg_rate;       //�킴�i�_���[�W�{���j

	//------�R���X�g���N�^-------
	//�R���X�g���N�^�@
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
		this.waza_nm = "����������";
		this.waza_dmg_rate = "1.0";
	}
	
	//�R���X�g���N�^�A
	Monster2( String tr,String nm ){
		this();
		this.trainer = tr;
		this.name = nm;
	}
	
	//�R���X�g���N�^�B
	Monster2( String tr,String nm,int initial_lv ){
		this(tr,nm);
		levelUp(initial_lv - 1);
	}
	
	//------���\�b�h-------
	//toString���\�b�h
	public String toString(){
		return "character:" + this.character + "/" + "trainer:" + this.trainer + "/" + "name:" + this.name + "/" + "lv:" + this.lv + "/" + "hp:" + this.lv + "/" + "atk:" + this.atk + "/" + "def:" + this.def + "/" + "spd:" + this.spd + "/" + "hp_max:" + this.hp_max + "/" + "waza_nm:" + this.waza_nm + "/" + "waza_dmg_rate:" + this.waza_dmg_rate ;
	}
	
	//levelUp���\�b�h
	public void levelUp( int lv_up ){
		if( lv_up == 0){
			//�����Ȃ�
		}else if( lv_up > 0 ){
			this.lv = this.lv + lv_up * 1;
			this.hp_max = this.hp_max + lv_up * 15;
			this.atk = this.atk + lv_up * 5;
			this.def = this.def + lv_up * 5;
			this.spd = this.spd + lv_up * 5;
			this.hp = this.hp_max;
		}
	}
	
	//setWaza���\�b�h
	public void setWaza( String wz_nm, String wz_dg_rt ){
		String str = wz_dg_rt ;
		
		if( str.matches("^[0-9]+\.[0-9]$")){
			this.waza_nm = wz_nm;
			this.waza_dmg_rate = wz_dg_rt;
		}else{
			System.out.println("[ERROR]�킴�̐ݒ�Ɏ��s���܂���");
		}
	}
	
	//getStatus���\�b�h
	public String getStatus(){
		String resultMessage = "[" + this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hp_max + "]" ;
		return resultMessage ;
	}
	
	//useWaza���\�b�h
	public int useWaza(){
		BigDecimal a = BigDecimal.valueOf(this.atk);
		BigDecimal w = new BigDecimal(this.waza_dmg_rate);
		BigDecimal give_dmg = (a.multiply(w)).setScale(0,BigDecimal.ROUND_DOWN);
		
		int result_give_dmg = give_dmg.intValue();
		
		return result_give_dmg;
	}
	
	//damaged���\�b�h
	public int damaged(int gv_dmg){
		//�_���[�W���Z�������߂�
		BigDecimal one = new BigDecimal("1");
		BigDecimal hun_twny = new BigDecimal("120");
		BigDecimal df = BigDecimal.valueOf(this.def);
		BigDecimal denom = one.add(df.divide(hun_twny));
		BigDecimal given_dmg_rate = one.divide(denom,2,BigDecimal.ROUND_UP);
		
		//���ۂɎ󂯂�_���[�W�����߂�
		BigDecimal gd = BigDecimal.valueOf(gv_dmg);
		BigDecimal given_dmg = gd.multiply(given_dmg_rate);
		int result_given_dmg = given_dmg.intValue();
		
		//HP�̕ω�
		if( this.hp > result_given_dmg ){
			this.hp = this.hp - result_given_dmg;
		}else{
			this.hp = 0;
		}
		return result_given_dmg;
	}
}
