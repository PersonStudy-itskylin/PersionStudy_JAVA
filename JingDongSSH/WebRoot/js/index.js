
		//��̬���� 
		function time(){

			var date = new Date();
			//��ȡ ��
			var y = date.getFullYear();
			//��ȡ ��  0 --> 11
			var M = date.getMonth() + 1;
			//��ȡ ��
			var d = date.getDate();
			//��ȡ ʱ
			var h = date.getHours();
			//��ȡ ��
			var m = date.getMinutes();
			//��ȡ ��
			var s = date.getSeconds();

			var date = y + " �� " + M + " �� " + d + " �� " + h + " ʱ : " + m + "�� : " + s + "��";
			//��ȡ ҳ����ʾ��λ��
			var time = document.getElementById('right').innerText = date;

			//��ʱ��  			1�����õķ���  2��ָ��ÿ���೤�¼�����  
			window.setTimeout("time()","1000");
			
		}

		//ҳ���������
		function openAD(){
			window.open("open.jsp","�������","width=670,height=530,top=80,left=350")
		}

		//ҳ����߹������
		function leftAD(){
			var top = 100;
			
			document.getElementById("leftAD").style.top = document.body.scrollTop + top;
			document.getElementById("rightAD").style.top = document.body.scrollTop + top;
		}

		window.onscroll = leftAD;

		//�ر���߹��
		function offLeft(){
			document.getElementById("leftAD").style.display = "none";
		}

		//�ر��ұ߹��
		function offRight(){
			document.getElementById("rightAD").style.display = "none";
		}

		//���б�ɫ
		function xiaoGuo(){
				
			//��ȡtable����
			var table = document.getElementById("content");
			//��ȡ�����������Ϣ
			var tr = table.getElementsByTagName("tr");
			
			//ѭ������
			for(var i=0;i<tr.length;i++){

				if(i % 2 == 0){
					//���Ϊż����
					tr[i].style.background = "#7EC0EE";

					//����ƿ�  ����ɫ��ԭ�� Ĭ�ϵ�ǰɫ
					tr[i].onmouseout = function(){
						this.style.background = "#7EC0EE";
					}
					
				}else{
					//�����б���ɫ
					tr[i].style.background = "#AEEEEE";


					//����ƿ�  ����ɫ��ԭ�� Ĭ�ϵ�ǰɫ
					tr[i].onmouseout = function(){
						this.style.background = "#AEEEEE";
					}
				}

				//����ƶ��� ����ɫ����
				tr[i].onmouseover = function(){
					this.style.background = "yellow";
				}
			}

		}

		//ɾ����Ʒ
		function del(id){

			/**
				confirm ���� ���� boolean ֵ
				true ��ʾ ����� ȷ��
				false ��ʾ ����� ȡ��
			*/
			if(window.confirm("ȷ��Ҫɾ������Ϣ��  ?")){
				//��ת�� Servlet �� �� ID  ��Ŵ��ݹ�ȥ
				window.location.href = "DeleteGoodsServlet?id=" + id;
			}
			
		}
