package pers.hanchao.basiccodeguideline.builder;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: 多参数构造方式汇总</P>
 *
 * @author hanchao
 * @date 2018/9/3 下午5:44
 */
public class Book {
    private Integer id;
    private String title;
    private String summary;
    private String author;
    private Double price;
    private List tags;

    /**
     * <p>Description: 第一种处理方式：多值构造器</p>
     */
    public Book(Integer id, String title, String summary, String author, Double price, String... tags) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.price = price;
        this.tags = Arrays.asList(tags);
    }

    /**
     * <p>Description: 第二种处理方式：setter</p>
     */
    public Book() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTags(String... tags) {
        this.tags = Arrays.asList(tags);
        ;
    }

    /**
     * <p>Description: 第三种处理方法：Builder构建器模式</p>
     */
    public static final class Builder {
        private Integer id;
        private String title;
        private String summary;
        private String author;
        private Double price;
        private List tags;

        private Builder() {
        }

        public static Builder aBook() {
            return new Builder();
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder tags(String... tags) {
            this.tags = Arrays.asList(tags);
            ;
            return this;
        }

        public Book build() {
            Book book = new Book(id, title, summary, author, price, tags);
            return book;
        }
    }

    public Book(Integer id, String title, String summary, String author, Double price, List tags) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.price = price;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", tags=" + tags +
                '}';
    }

    public static void main(String[] args) {
        //第一种处理方式：多值构造器
        //弊端：不利于阅读，容易出错
        Book book = new Book(1, "钢铁之躯", "这是一本好书", "张三", 12.99D, "科幻", "经典", "必读");
        System.out.println(book);

        //第二种处理方式：setter
        //弊端：在构造构成中可能处于不一致的状态，即：不是原子操作
        book = new Book();
        book.setId(1);
        book.setTitle("钢铁之躯");
        book.setSummary("这是一本好书");
        book.setAuthor("张三");
        book.setPrice(12.99D);
        book.setTags("科幻", "经典", "必读");
        System.out.println(book);

        //第三种处理方法：Builder构建器模式
        //弊端：稍微增加开销
        book = new Builder().id(1).title("钢铁之躯").summary("这是一本好书").author("张三").price(12.99D).tags("科幻", "经典", "必读").build();
        System.out.println(book);
    }
}
