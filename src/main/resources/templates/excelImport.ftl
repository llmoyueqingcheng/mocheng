<!DOCTYPE html>
<html lang="en">
<body>
	<div style="margin: 50px;">
		<input type="file" id="file" name="uplodefile"  enctype="multipart/form-data" onclick="clearProgressInfo()"/>
		<span id="progressInfo" style="display:none;">
		<progress id="progressBar" value="0" max="100"></progress>
		<span id="percentage">
			
		</span></span><br><br><br>
		<input type="button" onclick="UpladFile()" value="上传" />
	</div>
	<script>
		var xhr;
		function UpladFile() {
			var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
			var FileController = "${ctx}/credit/excelImport/do_exportImport"; // 接收上传文件的后台地址 

			// FormData 对象
			var form = new FormData();
			
			form.append("uplodefile", fileObj); // 文件对象

			// XMLHttpRequest 对象
			xhr = new XMLHttpRequest();
			xhr.open("post", FileController, true);
			xhr.onload = function() {
				//alert("上传完成!");
			};
			xhr.onreadystatechange = callback;
			document.getElementById("progressInfo").style.display = "";
			xhr.upload.addEventListener("progress", progressFunction, false);
			
			xhr.send(form);
		}
		
		function callback(){
            //判断对象状态是交互完成，接收服务器返回的数据
            if (xhr.readyState==4 && xhr.status==200)
            {
                 //纯文本的数据
                 var responseText = xhr.responseText;
                 responseText = JSON.parse(responseText);
                 //6.将服务器的数据显示在客户端
                 alert(responseText.msg)
             }    
        }
		function clearProgressInfo()
		{
			document.getElementById("progressInfo").style.display="none";
			document.getElementById("progressBar").value = 0;
			document.getElementById("percentage").innerHTML = "";
		}

		function progressFunction(evt) {
			var progressBar = document.getElementById("progressBar");
			var percentageDiv = document.getElementById("percentage");
			if (evt.lengthComputable) {
				progressBar.max = evt.total;
				progressBar.value = evt.loaded;
				percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
			}
		}
	</script>
</body>
</html>