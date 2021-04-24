$(document).ready(function () {

    $("#tag-create-button").click(async function () {

        let tagNameElement = document.getElementById("tag-name");
        let tagSlugElement = document.getElementById("tag-slug");

        let varData = {
            "name": tagNameElement.value,
            "slug": tagSlugElement.value
        };
        let response = await fetch("http://localhost:8080/tags", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(varData)
        }, {mode: 'cors'}).then(function (response) {
            console.log(response);

            if (response.status === 401) {
                alert("Необходима авторизация")
            } else if (response.status === 201) {
                alert("Успешно добавили новый тег")
                tagNameElement.value = "";
                tagSlugElement.value = "";
            } else {
                alert("Пролучили код " + response.status)
            }

        }).catch(function (error) {
            console.log("Не удалось создать тег", error);
        });
    });

    $(document).ready(function () {
        const location = window.location.toString();
        //Если это таблица тегов
        if (location.includes("tags/all.html")) {

            $.ajax({
                url: "http://localhost:8080/tags",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    const table = document.getElementById("tag-info-table");

                    for (let i = 0; i < response.length; i++) {

                        let row = table.insertRow(i + 1);
                        let tagId = row.insertCell(0);
                        let tagName = row.insertCell(1);
                        let tagSlug = row.insertCell(2);

                        tagId.innerHTML = response[i]["id"];
                        tagName.innerHTML = response[i]["name"];
                        tagSlug.innerHTML = response[i]["slug"];
                    }
                },
                error: function (error) {
                    console.log("Не удалось получить теги", error);
                }
            });
        }

        //Если это страница с созданием блога
        else if (location.includes("blogs/create.html")) {

            //Запрашиваем тегм
            $.ajax({
                url: "http://localhost:8080/tags",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    const element = document.getElementById("post-tags");

                    for (let i = 0; i < response.length; i++) {

                        let opt = document.createElement('option');
                        opt.value = response[i]["id"];
                        opt.innerHTML = response[i]["name"];
                        element.appendChild(opt);
                    }
                },
                error: function (error) {
                    console.log("Не удалось получить теги", error);
                }
            });

            //Запрашиваем авторов
            $.ajax({
                url: "http://localhost:8080/tags",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    const element = document.getElementById("post-tags");

                    for (let i = 0; i < response.length; i++) {

                        let opt = document.createElement('option');
                        opt.value = response[i]["id"];
                        opt.innerHTML = response[i]["name"];
                        element.appendChild(opt);
                    }
                },
                error: function (error) {
                    console.log("Не удалось получить теги", error);
                }
            });


        }
    });

});