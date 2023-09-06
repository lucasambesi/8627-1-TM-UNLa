export const stepPresenterMock = () => {

    const res = {
        step : {
            "idStep": 1,
            "idRecipe": 1,
            "description": "prender el horno"
        },
        steps: [
            {
              "idStep": 1,
              "idRecipe": 1,
              "description": "prender el horno"
            },
            {
              "idStep": 2,
              "idRecipe": 1,
              "description": "calentar carne"
            },
            {
              "idStep": 3,
              "idRecipe": 1,
              "description": "apagar horno"
            }
        ]
    }
    
    const getMock = () => {
        return res   
    }

    return {
        getMock,
    }
}