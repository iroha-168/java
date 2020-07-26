package work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**----------------------------------------------------------------------*
 *■■■ShowAllSurveyクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（回答入力画面の結果）を出力する。
 *----------------------------------------------------------------------**/
public class ShowAllSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAllSurvey() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンスの文字コードを設定
		response.setContentType("text/html;charset=UTF-8");
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");

		//ビジネスロジックを呼び出す
		BusinessLogic logic_ex = new BusinessLogic();
		List<SurveyDto> resultDto = logic_ex.executeSelectSurvey();

		//出力用のストリームの取得
		PrintWriter out = response.getWriter();

		//HTML文書（HTMLテーブル作成Sample画面）の出力
	    out.println( "<html>" ) ;
	    out.println( "<head>" ) ;
	    out.println( "<title>アンケート回答一覧</title>" ) ;
	    out.println( "</head>" ) ;
	    out.println( "<body>" ) ;
	    out.println( "<h2>アンケート回答一覧</h2>" ) ;

	    out.println( "<table class=\"list\" border=1 id=\"TABLE\">" ) ;
	    out.println(    "    <tr bgcolor=\"#c0c0c0\">                         "); //  trタグ：1行分の情報を表す（1行目）
		out.println(    "      <th>名前</th>                               "); //    thタグ：見出しを表す（1列目）
		out.println(    "      <th>年齢</th>                              "); //    thタグ：見出しを表す（2列目）
		out.println(    "      <th>性別</th>                              "); //    thタグ：見出しを表す（3列目）
		out.println(    "      <th>満足度</th>                              "); //    thタグ：見出しを表す（4列目）
		out.println(    "      <th>ご意見・ご感想</th>                              "); //    thタグ：見出しを表す（5列目）
		out.println(    "    </tr>                                            "); //  trタグ（閉じ）

		for(SurveyDto r: resultDto){
			out.println( "<tr>                                           ");
				out.println( "<td>" + r.getName() + "</td>                   ");
				out.println( "<td>" + r.getAge() + "</td>                    ");
				out.println( "<td>" + r.getSex() + "</td>                    ");
				out.println( "<td>" + r.getSatisfactionLevel() + "</td>      ");
				out.println( "<td>" + r.getMessage() + "</td>                ");
			out.println( "</tr>                                          ");
		}

		out.println( "</table>                                            ");

		out.println("  <a href=\"InputSurvey\">アンケート画面へ戻る</a>         "); //前の画面に戻るリンクの設定

		out.println(    "</body>                                              ");
		out.println(    "</html>                                              ");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}



