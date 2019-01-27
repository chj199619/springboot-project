KISSY.ready(function(S){
    KISSY.use("node", function(S, node) {
        var $ = node.all;
        var win = window, doc = document;
        var page = $('#content');
        var html = '<style>#alimm-pillar{width: 130px;height: 360px;position: fixed;top: 187px;margin-left: -140px;}</style><div id="alimm-pillar"><a style="display:none!important" id="tanx-a-mm_12852562_1778064_96170913"></a></div>';
        page.append(html);
        if(win.screen.width>1200){
            S.getScript("https://phs.tanx.com/ex?i=mm_12852562_1778064_96170913"+"&_t="+ new Date().getTime())
        }
    })
})
