
function layer_show_template(title,templateId,w,h,data){
   if (title == null || title == '') {
      title=false;
   };
   if (w == null || w == '') {
      w=800;
   };
   if (h == null || h == '') {
      h=($(window).height() - 50);
   };

   layer.open({
      type: 1,
      area: [w+'px', h +'px'],
      fix: false, //不固定
      maxmin: true,
      shade:0.4,
      title: title,
      content: template(templateId, data)
   });
}