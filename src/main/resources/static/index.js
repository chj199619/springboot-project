(function(a,e,i){var t=i.userAgent;var o=a.getElementsByTagName("head")[0];function n(e){var i=a.createElement("script");i.src=e;return o.appendChild(i)}var r="//g.alicdn.com";var c=self.goldlog;if(c&&c.getCdnPath){r=c.getCdnPath()}r+="/secdev/";var l=t.match(/Chrome\/(\d*)/);if(l){l=+l[1]}if(!a._sufei_data2){var m="3.6.8";var s=n(r+"sufei_data/"+m+"/index.js");s.id="aplus-sufei"}var f=.001;if(e()<f){a._linkstat_sample=f;n(r+"linkstat/index.js?v=1201")}window.nsrprtrt=1e-4;var v=0;if(location.host+location.pathname==="h5.m.taobao.com/app/moviemain/pages/show-cinema-list/index.html"){v=1}else if(!/Mobile/.test(t)){var d=["taobao.com","alibaba.com","alipay.com","tmall.com","lazada","aliexpress.com","1688.com","alimama.com","tb.cn","xiami.com","amap.com","cainiao.com","aliyun.com","etao.com","fliggy.com","liangxinyao.com","damai.cn","daraz.lk","tmall.hk","jiyoujia.com","taopiaopiao.com","alitrip.com","fliggy.hk","alihealth.cn","alitrip.hk","ele.me","gaode.cn"];for(var h=0;h<d.length;h++){if(location.host&&~location.host.indexOf(d[h])){v=1;break}}}if(v){var g=["1.0.52","b",63];var p=["1.0.52","b",63];var u=1e3;var _=0;function b(a){var e=0;for(var i=0;i<a.length;i++){e=(e<<5)-e+a.charCodeAt(i);e=e>>>0}return e}var k=a.cookie.match(/cna=([^;]+)/);k=k&&k[1];if(k&&b(k)%1e4<=u||u>=1e4){_=p}if(!_){return}var j=r+"nsv/"+_[0]+"/";var x=j+"ns_"+_[1]+"_"+_[2]+"_3_f.js";var y=j+"ns_"+_[1]+"_"+_[2]+"_3_n.js";function E(){var e="function%20javaEnabled%28%29%20%7B%20%5Bnative%20code%5D%20%7D";if("WebkitAppearance"in a.documentElement.style){if(escape(i.javaEnabled.toString())===e){return true}}return false}var C=t.match(/Edge\/([\d]*)/);var w=t.match(/Safari\/([\d]*)/);var A=t.match(/Firefox\/([\d]*)/);var B=t.match(/MSIE|Trident/);if(C){n(x)}else if(l){if(l>59){n(x)}else if(l<45){n(x)}else{n(x)}}else if(w||A||B){n(y)}else{if(E()){n(x)}else{n(y)}}}})(document,Math.random,navigator);