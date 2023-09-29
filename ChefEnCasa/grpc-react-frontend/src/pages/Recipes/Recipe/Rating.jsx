import React, { useEffect, useState } from "react";
import Box from '@mui/material/Box';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';

import { ratingPresenter } from '../../../presenter/RatingPresenter'
import { Stack } from "@mui/material";

export const CustomRating = (props) => {
  const [rating, setRating] = React.useState({});
  const [value, setValue] = React.useState(0);
  const [createMode, setCreateMode] = React.useState(true);

  const { getRatingByUserIdAndRecipeId, updateRating, addRating } = ratingPresenter()
  const { user, idRecipe, readOnly } = props;

  useEffect(() => {
    getRatingByUserIdAndRecipeId(user.idUser, idRecipe)
      .then((res) => {      
        if(res){
            setRating(res.rating)
            setValue(res.rating.value)
            setCreateMode(false)
        }
      })
      .catch((err) => console.log(err));
  }, []);

  const sendChangeValue = (value) => {
    if(createMode){
      sendAddRating(value)
    }
    else{
      sendUpdateRating(value)
    }
  }

  const sendAddRating = (value) => {

    const request = {
      "idUser": user.idUser,
      "idRecipe": idRecipe,
      "value":value
    }

    addRating(request)
    .then((res) => {
      if(res){
          setRating(res.rating)
          setValue(value)
          setCreateMode(false)
      }
    })
    .catch((err) => console.log(err));
  }

  const sendUpdateRating = (value) => {

    const request = {
      "idRating": rating.idRating,
      "idUser": user.idUser,
      "idRecipe": idRecipe,
      "value":value
    }

    let diffValue = "+0"

    if(value >= rating.value){
      diffValue = `+${value - rating.value}`
    }else{
      diffValue = `-${rating.value - value}`
    }

    updateRating(request, diffValue)
    .then((res) => {
      if(res){
          setRating(res.rating)
          setValue(value)
      }
    })
    .catch((err) => console.log(err));
  }

  return (
    <Box
      sx={{
        '& > legend': { mt: 2 },
      }}
    >
      {
         (readOnly == "true")
         ?
            <>
                <Rating name="read-only" value={value} readOnly />
            </>
         :
            <Stack direction={"row"} justifyContent={"start"} spacing={1}>
              <Rating
              name="simple-controlled"
              value={value}
              onChange={(event, newValue) => { sendChangeValue(newValue); }}
              />
              <Typography component="legend">
                {`( ${value} estrellas )`}
              </Typography>
            </Stack>
      }
    </Box>
  );
}