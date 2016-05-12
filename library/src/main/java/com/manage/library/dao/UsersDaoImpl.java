/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

//必要なライブラリをインポート。
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Users;

/**
 * dbのusersテーブルとのやり取りを記載するクラス。
 */
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

    /**
     * usersテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
     *
     * @return usersテーブルの全レコード
     */
    public List<Users> findAll() throws DataAccessException {
        // Users型の要素でできたrowMapperを生成する。
        RowMapper<Users> rowMapper = new UsersListRowMapper();
        // usersテーブルのデータ全てをテンプレートで返す。
        return getJdbcTemplate().query("select * from users;", rowMapper);
    }

    /**
     * usersテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
     *
     * @return userIdに対応するユーザ名
     */
    public String findUserNameFromUserId(int userId) {
        // ユーザIDの値があれば、対応するユーザ名を返す。
        if (userId != 0) {
            return getJdbcTemplate().queryForObject("select user_name from users where user_id=" + userId + ";",
                    String.class);
            // ユーザIDの値がなければ、空文字を返す。
        } else {
            return "";
        }
    }

    /**
     * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
     */
    protected class UsersListRowMapper implements RowMapper<Users> {

        /**
         * 実際にusersテーブルから得たデータを、オブジェクトに格納して返すメソッド。
         *
         * @return viewObj 各カラムのデータが格納されたオブジェクト
         */
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            // Users型のオブジェクトを生成する。ここに各カラムのデータを入れる。
            Users viewObj = new Users();
            // Usersクラスのsetterを用いて、それぞれ値を入れる。
            viewObj.setUserId(rs.getInt("user_id"));
            viewObj.setUserName(rs.getString("user_name"));
            // データを入れたオブジェクトを返す。
            return viewObj;
        }
    }
}
