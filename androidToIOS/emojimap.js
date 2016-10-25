//refer to http://www.iemoji.com/
var iosm={
		'😄':['1f604',':smile:'],
		'😔':['1f614',':pensive:'],
		'😊':['1f60a',':blush:'],
		'😜':['1f61c','stuck_out_tongue_winking_eye:']
}

var aMap={
		//people
		'':['😁',':grin:'],
		'':['😔',':pensive:'],
		'':['😊',':blush:'],
		'':['😜','stuck_out_tongue_winking_eye:'],
		'':['😳',':flushed:'],
		'':['👄',':lips:'],
		'':['😱',':scream:'],
		'':['😌',':relieved:'],
		'':['😍',''],
		'':['😣',':persevere:'],
		'':['😓',':sweat:'],
		'':['😏',':smirk:'],
		'':['😭',':sob:'],
		'':['😒',':unamused:'],
		'':['😄',':smile:'],
		'':['😖',':confounded:'],
		'':['😲',':astonished:'],
		'':['😉',':wink:'],
		'':['😘',':kissing_heart:'],
		'':['😝',':stuck_out_tongue_closed_eyes:'],
		'':['😂',':joy:'],
		'':['😡',':rage:'],
		'':['😠',':angry:'],
		'':['😥',':disappointed_relieved:'],
		'':['😷',':mask:'],
		'':['😪',':sleepy:'],
		'':['😨',':fearful:'],
		'':['😰',':cold_sweat:'],
		'':['😞',':disappointed:'],
		'':['😃',':smiley:'],
		'':['😘',':kissing_heart:'],
		'':['☺️',':relaxed:'],
		'':['👿',':imp:'],
		'':['💪',':muscle:'],
		'':['👊',':facepunch:'],
		'':['👍',':+1:'],
		'':['✌️',':v:'],
		'':['👎',':-1:'],
		'':['👆',':point_up_2:'],
		'':['👇',':point_down:'],
		'':['💍',':ring:'],
		'':['💔',':broken_heart:'],
		'':['👑',':crown:'],
		'':['💤',':zzz:'],
		'':['💩',':hankey:'],
		'':['😢',':cry:'],
		'':['🙏',':pray:'],
		'':['🎁',':gift:'],
		'':['🎂',':birthday:'],
		'':['💰',':moneybag:'],
		//objects
		'':['💝',':gift_heart:'],
		'':['🌹',':rose:'],
		'':['👻',':ghost:'],
		'':['🎉',':tada:']
		
}
/**搜狗、百度输入法以空格结尾，vivo没有空格，谷歌输入法同ios*/
function unify(text){
	var str = text.split('');
	for(var i=0;i<str.length;i++){
		if(str[i].charCodeAt()>255){
			var temp =str[i];
			if(aMap[temp]){
				str[i]=aMap[temp][0];
			}
			/*if(i+1<str.length && str[i+1]==" "){ 
				str[i+1]="";
			}*/
		}
	}
	return str.join('');
}