import React, { useEffect, useState } from "react";
import { News } from "./News";
import { Box, Container, Divider, Grid, Stack, Typography } from "@mui/material";

const Home = (props) => {
  
    return (
      <Container
        maxWidth={"lg"} 
        sx={
          {justifyContent:'center', alignContent: 'center', marginTop:"25px"}
        }>
          <Stack spacing={5} sx={{justifyContent:'center'}}>
            <Typography variant="h3" alignSelf={"center"} >
              {`Novedades`}
            </Typography>
            <Box>
              <Grid container rowSpacing={2} columnSpacing={{ xs: 1, sm: 2, md: 3 }} >
                <News />
              </Grid>
            </Box>
            <Divider component="div" variant="fullWidth" />
          </Stack>
      </Container>
    );
  }

export default Home;