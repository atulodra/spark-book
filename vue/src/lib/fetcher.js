import { toRefs, watchEffect, reactive } from 'vue';

export default function (url, mode, body) {
    const state = reactive({
        data: [],
        error: null,
        loading: true,
    });

    watchEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch(url, {
                    method: mode,
                    credentials: 'include',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(body),
                });
                const json = await res.json();
                if (Array.isArray(json)) {
                    state.data = json;
                } else if (typeof json === 'object') {
                    state.data.push(json);
                }
            } catch (e) {
                state.error = e;
            } finally {
                state.loading = false;
            }
        };
        fetchData();
    });

    return { ...toRefs(state) };
}
