<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html:html lang="ja">
<body>
    <html:form action="/VariousInput">
        <table border="1">
            <tr>
                <th>テキストボックス(name)</th>
                <td><html:text property="name" /></td>
            </tr>
            <tr>
                <th>パスワード(password)</th>
                <!-- 力されたパスワードを隠蔽する -->
                <td><html:password property="password" redisplay="false" /></td>
            </tr>
            <tr>
                <th>テキストエリア(etc)</th>
                <td><html:textarea property="etc" /></td>
            </tr>
            <tr>
                <th>チェックボックス デフォルトオフ（check1)</th>
                <td><html:checkbox property="check1" />チェック1</td>
            </tr>
            <tr>
                <!-- デフォルト値を設定する -->
                <th>チェックボックス デフォルトオン（check2）</th>
                <td><html:checkbox property="check2" value="on" />チェック2</td>
            </tr>
            <tr>
                <th rowspan="2">マルチボックス(multi1) 同じmulti1で複数の選択をサポート</th>
                <td><html:multibox property="multi1" value="Check1" />チェック1</td>
            </tr>
            <tr>
                <!-- 一まとまりとして管理する チェックボックスの例 -->
                <td><html:multibox property="multi1" value="Check2" />チェック2</td>
            </tr>
            <tr>
                <!-- 一まとまりとして管理する ラジオボタンの例 -->
                <th rowspan="2">ラジオボタン(radio1)
                    ラジオ1とラジオ2で同じradio1の属性のためどちらかしか選べない</th>
                <td><html:radio property="radio1" value="check1">ラジオ1</html:radio></td>
            </tr>
            <tr>
                <td><html:radio property="radio1" value="check2">ラジオ2</html:radio></td>
            </tr>
            <tr>
                <th>セレクト(select1) 複数選択不可</th>
                <td><html:select property="select1" value="S2">
                    <html:option value="S1">セレクト1</html:option>
                    <html:option value="S2">セレクト2(デフォルト値)</html:option>
                    <html:option value="S3">セレクト3</html:option>
                </html:select></td>
            </tr>
            <tr>
                <!-- 複数のデータを選択できるようにする -->
                <th>セレクト(select2) 複数選択可能</th>
                <td><html:select property="select2" multiple="true" size="3">
                    <html:option value="S1">リスト1</html:option>
                    <html:option value="S2">リスト2</html:option>
                    <html:option value="S3">リスト3</html:option>
                </html:select></td>
            </tr>
            <tr>
                <!-- リンクを作成する -->
                <th>リンクを記述するケース</th>
                <td><html:link href="http://localhost:8080/HelloStruts/Hello.jsp">
                                HelloStruts</html:link></td>
            </tr>
            <tr>
                <th>単純なイメージ</th>
                <td><html:img page="/image/img1.gif" /></td>
            </tr>
            <tr>
                <!-- 様々なボタンを表示する 通常のボタン -->
                <th>JavaScriptなどを実行するためのbuttonタグ(noReAction)の生成、
                    JavaScriptが実行されます</th>
                <td><html:button property="noReAction"
                        onclick="alert('ボタンが押されました')" /></td>
            </tr>
            <tr>
                <!-- 様々なボタンを表示する イメージボタン -->
                <th>イメージボタン(imagebutton) 押すとSubmitと同じ効果があります。</th>
                <td><html:image page="/image/img2.gif" property="imagebutton" /></td>
            </tr>
            <tr>
                <!-- 様々なボタンを表示する サブミットボタン -->
                <th>Submitボタン</th>
                <td><html:submit /><BR> <html:submit value="送信" /><BR>
                    <html:submit disabled="true" /><BR></td>
            </tr>


            <tr>
                <!-- 様々なボタンを表示する リセットボタン -->
                <th>Resetボタン</th>
                <td><html:reset /></td>
            </tr>
            <tr>
                <th>キャンセルボタン、リクエストがサーバに行く。
                    処理を記述しないとSubmitと同じ操作</th>
                <!-- 様々なボタンを表示する キャンセルボタン -->
                <td><html:cancel /></td>
            </tr>
        </table>
        <!-- 入力フォーム内に不可視フィールドを作成する -->
        <html:hidden property="hidden1" value="hidden1" />
    </html:form>
</body>
</html:html>
