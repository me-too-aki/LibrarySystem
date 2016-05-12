/**
 *  Daoのパッケージ。
 */
package com.manage.library.dao;

//  必要なライブラリをインポート。
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.LendedHistorys;
import com.manage.library.LendedHistorysJoinUsers;
import com.manage.library.Users;

/**
 * dbの、lended_historys,usersを結合したテーブルとのやり取りを記載するクラス。
 */
public class LendedHistorysJoinUsersDaoImpl extends JdbcDaoSupport implements LendedHistorysJoinUsersDao {

    /**
     * 結合したテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
     *
     * @return lended_history,usersを結合したテーブルの全レコード
     */
    public List<LendedHistorysJoinUsers> findAll() throws DataAccessException {
        // 結合したテーブルモデルの要素でできたrowMapperを生成する。
        RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
        // 結合したテーブルのデータ全てをテンプレートで返す。
        return getJdbcTemplate().query("select * from lended_historys inner join users on borrow_user_id = user_id;",
                rowMapper);
    }

    /**
     * 結合したテーブルから、対応するidのレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
     *
     * @param id
     * @return lended_history,usersを結合したテーブルの、idに対応するレコード
     */
    public List<LendedHistorysJoinUsers> findFromId(int id) {
        // 結合したテーブルモデルの要素でできたrowMapperを生成する。
        RowMapper<LendedHistorysJoinUsers> rowMapper = new HomeListRowMapper();
        // 結合したテーブルの、idに対応するレコードをテンプレートで返す。
        return getJdbcTemplate().query(
                "select * from lended_historys inner join users on borrow_user_id = user_id where book_id=" + id + ";",
                rowMapper);
    }

    /**
     * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
     */
    protected class HomeListRowMapper implements RowMapper<LendedHistorysJoinUsers> {

        /**
         * 実際に結合したテーブルから得たデータを、オブジェクトに格納して返すメソッド。
         *
         * @return viewObj 各カラムのデータが格納されたオブジェクト
         */
        public LendedHistorysJoinUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
            // 結合したテーブルのオブジェクトを生成する。
            LendedHistorysJoinUsers viewObj = new LendedHistorysJoinUsers();
            // LendedHistorys型のオブジェクトを生成する。ここに各カラムのデータを入れる。
            LendedHistorys lendedHistorys = new LendedHistorys();
            // Users型のオブジェクトを生成する。ここに各カラムのデータを入れる。
            Users users = new Users();

            // クラスのsetterを用いて、それぞれ値を入れる。
            lendedHistorys.setHistoryId(rs.getInt("history_id"));
            lendedHistorys.setBookId(rs.getInt("book_id"));
            lendedHistorys.setLendedAt(rs.getTimestamp("lended_at"));
            lendedHistorys.setReturnedAt(rs.getTimestamp("returned_at"));
            lendedHistorys.setBorrowUserId(rs.getInt("borrow_user_id"));
            users.setUserId(rs.getInt("user_id"));
            users.setUserName(rs.getString("user_name"));

            // 結合したテーブルのオブジェクトに、lended_historysテーブルのデータを入れる。
            viewObj.setLendedHistorys(lendedHistorys);
            // 結合したテーブルのオブジェクトに、usersテーブルのデータを入れる。
            viewObj.setUsers(users);
            // データを入れたオブジェクトを返す。
            return viewObj;
        }
    }

}
