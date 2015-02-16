package cn.saymagic.utils;

/**
 * Created by saymagic on 15/2/1.
 */
public class StringUtils {
    /**
     * 检验邮箱格式是否正确
     * @param target
     * @return
     */
    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target)
                    .matches();
        }
    }
}
