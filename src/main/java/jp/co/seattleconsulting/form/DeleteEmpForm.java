package jp.co.seattleconsulting.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;


/**
 * 論理削除時にクライアントサイドから値を得る.
 *
 * @author Endo
 */
@Component(instance = InstanceType.SESSION)
public class DeleteEmpForm implements Serializable{
    private static final long serialVersionUID = 1L;

	public Integer empNo;

}
