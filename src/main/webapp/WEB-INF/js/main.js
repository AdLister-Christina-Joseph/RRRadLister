"use strict"

const searchResults = document.getElementById("ad-results");
const form = document.getElementsByName("searchField");
const search = document.getElementById("search");
$( document ).ready(function() {
    // SUBMIT EVENT LISTENER
    form.addEventListener("submit", (e) => {
        e.preventDefault();
        //console.log(search.value);
        const query = search.value;
        if (query) {
            const queryUrl = dbURL + "?q=" + query;
            getAdSearch(queryUrl);
        }
    });
    //
    async function getAdSearch(searchResult) {
        const respData = await resp.json(searchResult);
        if (respData.length === 0) {
            searchResults.innerHTML = '<h3>No results found</h3>';
        } else {
            showSearchedAds(respData);
        }
    }
    function showSearchedAds(ads) {
        document.innerHTML = document.getElementById("ad-results");
        ads.forEach((ads) => {
            const id = ads.id;
            const title = ads.title;
            const description = ads.description;
            const Price = ads.Price;
            const user_id = ads.user_id;
        })
    }

    $.getJSON(dbURL, function (data) {
        let searchResult = [];
        $.each(data, function (key, val) {
            searchResult.push("<li id='" + key + "'>" + val + "</li>");
        });

        $("<ul/>", {
            "class": "ad-results",
            html: searchResult.join("")
        }).appendTo("body");
    });

        //     END OF DOCUMENT
        });