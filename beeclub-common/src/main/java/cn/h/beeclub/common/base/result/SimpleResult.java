package cn.h.beeclub.common.base.result;

import cn.h.beeclub.common.util.PageUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <T> 表示data类型
 */
@Data
public class SimpleResult<T> implements Serializable {

    private static final long serialVersionUID = 2173548678075209319L;
    private int code;
    private String msg;
    private T data;

	public static <T> SimpleResult<PageResult<T>> page(List<T> list){
        return SimpleResult.ok(PageUtils.pageConvertPageResult(list));
    }

    public static <T> SimpleResult<T> ok(T data){
        return new SimpleResult<T>(data);
    }
    
    public static SimpleResult<Boolean> ok(){
        return new SimpleResult<Boolean>(Boolean.TRUE);
    }
    
    public static <T> SimpleResult<T> fail(String msg){
        return new SimpleResult<T>(-1,msg);
    }
    
    public static <T> SimpleResult<T> noAuth(String msg){
        return new SimpleResult<T>(401,msg);
    }
    
    public static <T> SimpleResult<T> authFail(String msg){
        return new SimpleResult<T>(402,msg);
    }

    public SimpleResult(){}
    public SimpleResult(String msg){
        this.msg = msg;
    }

    public SimpleResult(T data){
        this.data = data;
    }


    public SimpleResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public SimpleResult(int code,T data){
        this.code = code;
        this.data = data;
    }

    public SimpleResult(String msg,T data){
        this.msg = msg;
        this.data = data;
    }

    public SimpleResult(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
