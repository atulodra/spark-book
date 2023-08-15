<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import fetcher from '../lib/fetcher';

const route = useRoute();
// const router = useRouter();
const id = parseInt(route.params.id);
// const book = ref({});
// fetch(`http://localhost:8221/api/book/${id}`, {
//     method: 'GET',
//     credentials: 'include',
//     headers: {
//         'Content-Type': 'application/json',
//     },
// })
//     .then(response => response.json())
//     .then(data => book.value = data);


const { data, error, loading } = fetcher(`http://localhost:8221/api/book/${id}`, 'GET');
console.log(data);
const deleteBook = () => {
    fetch(`http://localhost:8221/api/book/${id}`, {
        method: 'DELETE',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
        },
    })

}
</script>
<template>
    <div v-if="!loading" class="book-container">
        <div class="image-container">
            <img class="book-image" :src="data[0].cover">
        </div>
        <div class="book-details">
            <h1>{{ data[0].title }}</h1>
            <div class="book-detail-values">
                <div class="book-detail-value">
                    <p class="book-detail-field">Author:</p>
                    <p>{{ data[0].author }}</p>
                </div>
                <div class="book-detail-value">
                    <p class="book-detail-field">ISBN:</p>
                    <p>{{ data[0].ISBN }}</p>
                </div>
                <div class="book-detail-value">
                    <p class="book-detail-field">Publisher:</p>
                    <p>{{ data[0].publisher }}</p>
                </div>
                <div class="book-detail-value">
                    <p class="book-detail-field">Publication Date:</p>
                    <p>{{ data[0].publicationDate }}</p>
                </div>
            </div>
            <button @click="deleteBook">Delete</button>
        </div>
    </div>
    <div v-else class="book-container" style="justify-content: center;">
        <p class="loading">LOADING...</p>
    </div>
</template>

<style scoped>
h1 {
    font-weight: bold;
    color: white;
    /* color: thistle; */
}

.book-container {
    display: flex;
    /* justify-content: center; */
    padding: 40px;
    gap: 30px;
}

.image-container {
    width: 30%;
    border: 1px solid white;
    display: flex;
    justify-content: center;
    align-content: center;
    padding: 20px;
    border-radius: 20px;
}

.book-image {
    width: 400px;
    height: 500px;
    /* position: relative; */
    object-fit: cover;
}

.book-detail-value {
    display: flex;
    gap: 25px;
    color: snow;
}

.book-detail-field {
    font-weight: bold;
    color: thistle;
}
</style>