package work;

import java.util.List;

/**----------------------------------------------------------------------*
 *■■■BusinessLogicクラス■■■
 *概要：ビジネスロジック（アンケートデータの登録）
 *----------------------------------------------------------------------**/
public class BusinessLogic {

	/**----------------------------------------------------------------------*
	 *■executeInsertSurveyメソッド
	 *概要　：対象のアンケートデータを登録する(INSERT)
	 *引数　：対象のアンケートデータ（SurveyDto型）
	 *戻り値：DB操作成功フラグ（true:成功/false:失敗）
	 *----------------------------------------------------------------------**/
	public boolean executeInsertSurvey(SurveyDto dto) {

		boolean   succesInsert = false ;  //DB操作成功フラグ（true:成功/false:失敗）

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//DAOクラスをインスタンス化＆対象のユーザーデータを登録するよう依頼
		SurveyDao dao = new SurveyDao();
		succesInsert = dao.doInsert(dto);

		return succesInsert;
	}

	/**----------------------------------------------------------------------*
	 *■executeSelectSurveyメソッド
	 *概要　：対象のアンケートデータを選択してくる(SELECT)
	 *引数　：なし
	 *戻り値：SurvayDto
	 *----------------------------------------------------------------------**/

	public List<SurveyDto> executeSelectSurvey() {
		SurveyDao dao_ex = new SurveyDao();
		List<SurveyDto> extractedDto = dao_ex.doSelect();
		return extractedDto ;
	}

}


