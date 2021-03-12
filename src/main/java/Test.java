// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import com.google.ads.googleads.lib.GoogleAdsClient;
import com.google.ads.googleads.v6.services.GoogleAdsServiceClient;
import com.google.ads.googleads.v6.services.GoogleAdsServiceClient.SearchPagedResponse;
import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {
    GoogleAdsClient client = GoogleAdsClient.newBuilder().fromPropertiesFile().build();
    try (GoogleAdsServiceClient googleAdsServiceClient = client.getLatestVersion()
        .createGoogleAdsServiceClient()) {
      SearchPagedResponse response = googleAdsServiceClient.search(String.valueOf(args[0]),
          "select campaign.id, campaign.name from campaign where campaign.status = 'ENABLED'");
      response.iterateAll().forEach(System.out::println);
    }

  }
}
