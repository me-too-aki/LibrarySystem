/**
 *   Daoのパッケージ。
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
import com.manage.library.Books;
import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.Lendings;
import com.manage.library.Users;

/**
 * dbの、books,lendings,usersを結合したテーブルとのやり取りを記載するクラス。
 */
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

    /**
     * 結合したテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
     *
     * @return books,lendings,usersを結合したテーブルの全レコード
     */
    public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {

        // 結合したテーブルモデルの要素でできたrowMapperを生成する。
        RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
        // 結合したテーブルのデータ全てをテンプレートで返す。
        return getJdbcTemplate().query(
                "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
                rowMapper);
    }

    /**
     * 結合したテーブルから、対応するレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
     *
     * @param id
     * @return books,lendings,usersを結合したテーブルの、idに対応するレコード
     */
    public List<BooksJoinLendingsAndUsers> findFromId(int id) {
        // 結合したテーブルモデルの要素でできたrowMapperを生成する。
        RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
        // 結合したテーブルの、idに対応するレコードをテンプレートで返す。
        return getJdbcTemplate().query(
                "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
                + id + ";",
                rowMapper);
    }

    /**
     * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
     */
    protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

        /**
         * 実際に結合したテーブルから得たデータを、オブジェクトに格納して返すメソッド。
         *
         * @return viewObj 各カラムのデータが格納されたオブジェクト
         */
        public BooksJoinLendingsAndUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
            // 結合したテーブルのオブジェクトを生成する。
            BooksJoinLendingsAndUsers viewObj = new BooksJoinLendingsAndUsers();

            // Books型のオブジェクトを生成する。ここに各カラムのデータを入れる。
            Books books = new Books();
            // Lendings型のオブジェクトを生成する。ここに各カラムのデータを入れる。
            Lendings lendings = new Lendings();
            // Users型のオブジェクトを生成する。ここに各カラムのデータを入れる。
            Users users = new Users();

            // クラスのsetterを用いて、それぞれ値を入れる。
            books.setBookId(rs.getInt("books.book_id"));
            books.setBookTitle(rs.getString("books.book_title"));
            books.setWritterName(rs.getString("books.writter_name"));
            books.setPublisher(rs.getString("books.publisher"));
            books.setPublishedAt(rs.getDate("books.published_at"));
            books.setOwnerUserId(rs.getInt("books.owner_user_id"));
            books.setRegisteredAt(rs.getTimestamp("books.registered_at"));
            lendings.setBookId(rs.getInt("lendings.book_id"));
            lendings.setLendingStatus(rs.getBoolean("lendings.lending_status"));
            lendings.setLendedAt(rs.getTimestamp("lendings.lended_at"));
            lendings.setDueDate(rs.getDate("lendings.due_date"));
            lendings.setBorrowUserId(rs.getInt("lendings.borrow_user_id"));
            users.setUserId(rs.getInt("users.user_id"));
            users.setUserName(rs.getString("users.user_name"));

            // 結合したテーブルのオブジェクトに、booksテーブルのデータを入れる。
            viewObj.setBooks(books);
            // 結合したテーブルのオブジェクトに、lendingsテーブルのデータを入れる。
            viewObj.setLendings(lendings);
            // 結合したテーブルのオブジェクトに、usersテーブルのデータを入れる。
            viewObj.setUsers(users);
            // データを入れたオブジェクトを返す。
            return viewObj;
        }
    }

}
