package com.ketayao.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;

@Controller
public class WechatEmoji {
	private static Properties props = null;
	private final static Map map = new HashMap();
	static {
		map.put("微笑", "/::)");
		map.put("撇嘴", "/::~");
		map.put("色", "/::B");
		map.put("发呆", "/::|");
		map.put("得意", "/:8-)");
		map.put("流泪", "/::<");
		map.put("害羞", "/::$");

		map.put("闭嘴", "/::X");
		map.put("睡", "/::Z");
		map.put("大哭", "/::'(");
		map.put("尴尬", "/::-|");
		map.put("发怒", "/::@");
		map.put("调皮", "/::P");
		map.put("呲牙", "/::D");

		map.put("惊讶", "/::O");
		map.put("难过", "/::(");
		map.put("酷", "/::+");
		map.put("冷汗", "/:--b");
		map.put("抓狂", "/::Q");
		map.put("吐", "/::T");

		map.put("偷笑", "/:,@P");
		map.put("愉快", "/:,@-D");
		map.put("白眼", "/::d");
		map.put("傲慢", "/:,@o");
		map.put("饥饿", "/::g");
		map.put("困", "/:|-)");
		map.put("惊恐", "/::!");

		map.put("流汗", "/::L");
		map.put("憨笑", "/::>");
		map.put("悠闲", "/::,@");
		map.put("奋斗", "/:,@f");
		map.put("咒骂", "/::-S");
		map.put("疑问", "/:?");
		map.put("嘘", "/:,@x");

		map.put("晕", "/:,@@");
		map.put("疯了", "/::8");
		map.put("衰", "/:,@!");
		map.put("骷髅", "/:!!!");
		map.put("敲打", "/:xx");
		map.put("再见", "/:bye");

		map.put("擦汗", "/:wipe");
		map.put("抠鼻", "/:dig");
		map.put("鼓掌", "/:handclap");
		map.put("糗大了", "/:&-(");
		map.put("坏笑", "/:B-)");
		map.put("左哼哼", "/:<@");
		map.put("右哼哼", "/:@>");

		map.put("哈欠", "/::-O");
		map.put("鄙视", "/:>-|");
		map.put("委屈", "/:P-(");
		map.put("快哭了", "/::'|");
		map.put("阴险", "/:X-)");
		map.put("亲亲", "/::*");
		map.put("吓", "/:@x");

		map.put("可怜", "/:8*");
		map.put("菜刀", "/:pd");
		map.put("西瓜", "/:<W>");
		map.put("啤酒", "/:beer");
		map.put("篮球", "/:basketb");
		map.put("乒乓", "/:oo");
		map.put("咖啡", "/:coffee");
		map.put("饭", "/:eat");
		map.put("猪头", "/:pig");
		map.put("玫瑰", "/:rose");
		map.put("凋谢", "/:fade");
		map.put("嘴唇", "/:showlove");
		map.put("爱心", "/:heart");
		map.put("心碎", "/:break");

		map.put("蛋糕", "/:cake");
		map.put("闪电", "/:li");
		map.put("炸弹", "/:bome");
		map.put("刀", "/:kn");
		map.put("足球", "/:footb");
		map.put("瓢虫", "/:ladybug");
		map.put("便便", "/:shit");
		map.put("月亮", "/:moon");
		map.put("太阳", "/:sun");
		map.put("礼物", "/:gift");
		map.put("拥抱", "/:hug");
		map.put("强", "/:strong");
		map.put("弱", "/:weak");
		map.put("握手", "/:share");
		map.put("胜利", "/:v");
		map.put("抱拳", "/:@)");
		map.put("勾引", "/:jj");
		map.put("拳头", "/:@@");
		map.put("差劲", "/:bad");
		map.put("爱你", "/:lvu");
		map.put("NO", "/:no");
		map.put("OK", "/:ok");
		map.put("爱情", "/:love");
		map.put("飞吻", "/:<L>");
		map.put("跳跳", "/:jump");
		map.put("发抖", "/:shake");
		map.put("怄火", "/:<O>");
		map.put("转圈", "/:circle");
		map.put("磕头", "/:kotow");
		map.put("回头", "/:turn");
		map.put("跳绳", "/:skip");
		map.put("右太极", "/:&>");
		map.put("激动", "/:#-0");
		map.put("乱舞", "/:hiphot");
		map.put("献吻", "/:kiss");
		map.put("左太极", "/:<&");
		map.put("投降", "/:oY");
		map.put("嘿哈", "/:heiha");
		map.put("捂脸", "/:wulian");
		map.put("奸笑", "/:jianxiao");
		map.put("机智", "/:jizhi");
		map.put("皱眉", "/:zhoumei");
		map.put("耶", "/:ye");
		map.put("茶", "/:cha");
		map.put("红包", "/:hongbao");
		map.put("蜡烛", "/:lazhu");
		map.put("囧", "/:--b");
		try {
			props = PropertiesLoaderUtils.loadAllProperties("wechat_emotion.properties");
			// System.out.println(props.stringPropertyNames());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String emoji(String text) {
		System.out.println(StringEscapeUtils.unescapeHtml(text));
		System.out.println(StringEscapeUtils.unescapeJava(text));
		System.out.println(StringEscapeUtils.unescapeJavaScript(text));

		text = StringEscapeUtils.unescapeJavaScript(text);
		Iterator it = map.keySet().iterator();
		StringBuffer cnb = new StringBuffer();
		StringBuffer enb = new StringBuffer();
		while (it.hasNext()) {
			Object o = it.next();
			cnb.append("\\[").append(o).append("\\]|");
			enb.append(escapeExprSpecialWord(String.valueOf(map.get(o))))
					.append("|");
		}
		String enstr = enb.toString().substring(0, enb.length() - 1);
		String cnstr = cnb.toString().substring(0, cnb.length() - 1);
		WechatEmoji e = new WechatEmoji();
		return e.wechatEmojiEn(enstr, e.wechatEmojiCn(cnstr, text));
	}

	/**
	 * 英文表情转图 包含回车换行符的处理
	 */
	private String wechatEmojiEn(String reg, String text) {
		reg = "(?s)" + reg;
		Pattern en = Pattern.compile(reg, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);

		Matcher m = en.matcher(text);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String key = m.group();
			try {
				m.appendReplacement(sb, props.getProperty(key));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 中文表情编码转英文
	 */
	private String wechatEmojiCn(String reg, String text) {
		reg = "(?s)" + reg;
		// Pattern en =
		// Pattern.compile("(?s)\\/::\\)|\\/::~|\\/::B|\\/::\\|\\/:8-\\)|\\/::<|\\/::$|/::X|\\/::Z|\\/::\\'\\(|\\/::-\\||\\/::@|\\/::P|\\/::D|\\/::O|\\/::\\(|\\/::\\+|\\/:--b|\\/::Q|\\/::T|\\/:,@P|\\/:,@-D|\\/::d|\\/:,@o|\\/::g|\\/:\\|-|\\/::L|/::>|\\/::,@|\\/:,@f|\\/::-S|\\/:\\?|\\/:,@x|/:,@@|\\/::8|/:xx|\\/:bye|\\/:wipe|\\/:dig|\\/:handclap|\\/:&-\\(|\\/:B-\\)|\\/:<@|\\/:@>|\\/::-O|\\/:>-\\||\\/:P-\\(|\\/::'\\||\\/:X-\\)|\\/::\\*|\\/:@x|\\/:8\\*|\\/:pd|\\/:<W>|\\/:beer|\\/:basketb|\\/:oo|\\/:coffee|\\/:eat|\\/:pig|\\/:rose|\\/:fade|\\/:showlove|\\/:heart|\\/:break|\\/:cake|\\/:li|\\/:bome|\\/:kn|\\/:footb|\\/:ladybug|\\/:shit|\\/:moon|\\/:sun|\\/:gift|\\/:hug|\\/:strong|\\/:weak|\\/:share|\\/:v|\\/:@\\)|\\/:jj|\\/:@@|\\/:bad|\\/:lvu|\\/:no|\\/:ok|\\/:love|\\/:<L>|\\/:jump|\\/:shake|\\/:<O>|\\/:circle|\\/:kotow|\\/:turn|\\/:skip|\\/:oY",
		// Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Pattern en = Pattern.compile(reg, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);

		Matcher m = en.matcher(text);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String key = m.group().toUpperCase();
			key = key.substring(1, key.length() - 1);
			try {
				String s = String.valueOf(map.get(key));
				if (s == "/::$") {// $特殊处理
					s = "/::\\$";
				}
				m.appendReplacement(sb, s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 字符串转义
	 * 
	 * @param keyword
	 * @return
	 */
	public static String escapeExprSpecialWord(String keyword) {
		if (StringUtils.isNotBlank(keyword)) {
			String[] fbsArr = { "\\", "/", "$", "(", ")", "*", "+", ".", "[",
					"]", "?", "^", "{", "}", "|" };
			for (String key : fbsArr) {
				if (keyword.contains(key)) {
					keyword = keyword.replace(key, "\\" + key);
				}
			}
		}
		return keyword;
	}

	public static void main(String args[]) {
		String string = "\"text\":\"/::\u0027(\",\"";
		System.out.println(emoji(string));
		// wechatEmojiEn();
	}
}
