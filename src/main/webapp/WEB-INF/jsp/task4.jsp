<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task4</title>
    <script type="text/javascript" src="resources/js/jquery-2.1.4.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var translit = [];
            translit['а'] = 'a';
            translit['б'] = 'b';
            translit['в'] = 'v';
            translit['г'] = 'g';
            translit['д'] = 'd';
            translit['е'] = 'e';
            translit['ё'] = 'jo';
            translit['ж'] = 'zh';
            translit['з'] = 'z';
            translit['и'] = 'i';
            translit['й'] = 'j';
            translit['к'] = 'k';
            translit['л'] = 'l';
            translit['м'] = 'm';
            translit['н'] = 'n';
            translit['о'] = 'o';
            translit['п'] = 'p';
            translit['р'] = 'r';
            translit['с'] = 's';
            translit['т'] = 't';
            translit['у'] = 'u';
            translit['ф'] = 'f';
            translit['х'] = 'h';
            translit['ц'] = 'c';
            translit['ч'] = 'ch';
            translit['ш'] = 'sh';
            translit['щ'] = 'shh';
            translit['ъ'] = '#';
            translit['ы'] = 'y';
            translit['ь'] = '\'';
            translit['э'] = 'je';
            translit['ю'] = 'ju';
            translit['я'] = 'ja';
            translit['А'] = 'A';
            translit['Б'] = 'B';
            translit['В'] = 'V';
            translit['Г'] = 'G';
            translit['Д'] = 'D';
            translit['Е'] = 'E';
            translit['Ё'] = 'Jo';
            translit['Ж'] = 'Zh';
            translit['З'] = 'Z';
            translit['И'] = 'I';
            translit['Й'] = 'J';
            translit['К'] = 'K';
            translit['Л'] = 'L';
            translit['М'] = 'M';
            translit['Н'] = 'N';
            translit['О'] = 'O';
            translit['П'] = 'P';
            translit['Р'] = 'R';
            translit['С'] = 'S';
            translit['Т'] = 'T';
            translit['У'] = 'U';
            translit['Ф'] = 'F';
            translit['Х'] = 'H';
            translit['Ц'] = 'C';
            translit['Ч'] = 'Ch';
            translit['Ш'] = 'Sh';
            translit['Щ'] = 'Shh';
            translit['Ъ'] = '##';
            translit['Ы'] = 'Y';
            translit['Ь'] = '\'\'';
            translit['Э'] = 'Je';
            translit['Ю'] = 'Ju';
            translit['Я'] = 'Ja';

            $("#inputForm").submit(function(event) {
                event.preventDefault();
                var txt = $("#textInput").val();
                var charsWords = txt.split(' ');
                var charsWordsRev = txt.split(' ');

                for(i = 0; i < charsWords.length; i++)
                {
                    var chars = charsWords[i].split('');
                    var charsRev = charsWords[i].split('');
                    for(j = 0; j < chars.length; j++)
                    {
                        if(translit[chars[j]] != null) {
                            chars[j] = translit[chars[j]];
                        }
                        charsRev[chars.length - 1 - j] = chars[j];
                    }
                    charsWords[i] = chars.join('');
                    charsWordsRev[i] = charsRev.join('');
                }

                txt = charsWords.join(' ');
                var txtRev = charsWordsRev.join(' ');
                $("#translit").text(txt);
                $("#translitReverse").text(txtRev);
            });
        });
    </script>

</head>
<body>
<form action="" id="inputForm">
    <p><label for="textInput">Введите текст</label></p>
    <p><textarea id="textInput" cols="30" rows="4"></textarea></p>
    <p><input type="submit" value="Напечатать"/></p>
</form>
<div id="translit"></div>
<div id="translitReverse"></div>

</body>
</html>
